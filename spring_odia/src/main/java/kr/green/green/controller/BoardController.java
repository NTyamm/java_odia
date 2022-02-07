package kr.green.green.controller;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import kr.green.green.pagination.Criteria;
import kr.green.green.pagination.PageMaker;
import kr.green.green.service.BoardService;
import kr.green.green.vo.BoardVO;
import kr.green.green.vo.CommentVO;
import kr.green.green.vo.FileVO;
import kr.green.green.vo.LikesVO;
import kr.green.green.vo.MemberVO;

@Controller
//리퀘스트매핑이 들어가야 함-요청 URL을 어떤 메소드가 처리할지 결정함
@RequestMapping(value="/board")
public class BoardController {

	@Autowired //서비스 인터페이스 연결 필요
	BoardService boardService;
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public ModelAndView boardList(ModelAndView mv, Criteria cri) {
		//페이네이션 정보 추가
		cri.setPerPageNum(3);
		//VO를 이용해 리스트 정보 불러오기. VO 클래스 연결 필요. "일반"을 매개변수 cri로 변경
		List<BoardVO> list = boardService.getBoardList(cri);
		//페이지메이커를 만들어서 화면에 전달해야 함. 
		//가져온 게시글들을 설정한 페이지네이션의 페이지 수, 매개변수로 전달받은 현재 페이지 정보를 이용해 페이지 메이커로 정리
		int totalCount = boardService.getTotalCount(cri);
		PageMaker pm = new PageMaker(totalCount, 3, cri);
		mv.addObject("pm", pm);
		mv.addObject("list",list)
		  .setViewName("/board/list"); //세미콜론을 안 쓰고 mv에 묶을 수 있음
		return mv;
	}
	@RequestMapping(value="/detail", method=RequestMethod.GET)
	public ModelAndView boardDetail(ModelAndView mv, Integer bd_num) {
				//VO를 이용해 boardService에게 bd_num에 따른 board정보를 가져오게 시킴
		BoardVO board = boardService.getBoard(bd_num);
		List<FileVO> files = boardService.getFileList(bd_num);
		//views 를 증가시키기 위해 boardService 이용
		boardService.updateViews(bd_num);
		mv.addObject("board",board);
		mv.addObject("files",files);
		mv.setViewName("/board/detail");
		return mv;
	}
	@RequestMapping(value = "/register", method  = RequestMethod.GET)
	public ModelAndView boardRegisterGet(ModelAndView mv, BoardVO board) {
		mv.addObject("board", board);
		mv.setViewName("/board/register");
		return mv;
	}
	@RequestMapping(value="/register", method = RequestMethod.POST)
	public ModelAndView boardRegisterPOST(ModelAndView mv, BoardVO board, 
			HttpServletRequest request, List<MultipartFile> files2) throws Exception {
		//로그인 회원 정보를 이용해 글쓴이를 등록하므로 로그인 세션의 유저정보 가지고 와야 함
		MemberVO user = (MemberVO) request.getSession().getAttribute("user");
		//글쓴이를 로그인 세션의 유저 아이디로 설정함
		board.setBd_me_id(user.getMe_id());
		//공지사항이 아니기 때문에 "일반"으로 게시판 타입 지정해줘야 함`````````````	
		//???여기서 왜 유저정보가 사라지고 갑자기 파일스가 되는거지?????
		boardService.registerBoard(board, files2, user);
		mv.addObject("type", board.getBd_type());//글작성후 글 작성한 게시판 리스트로 돌아가게 
		mv.setViewName("redirect:/board/list");
		return mv;
	}
	@RequestMapping(value = "/modify", method  = RequestMethod.GET)
	public ModelAndView boardModifyGet(ModelAndView mv, Integer bd_num, HttpServletRequest request) {
		//로그인 회원 정보를 이용해 글쓴이를 확인하므로 로그인 세션의 유저정보 가지고 와야 함
		MemberVO user = (MemberVO) request.getSession().getAttribute("user");
		//게시글 번호에 따른 게시글 정보를 가져옴
		BoardVO board = boardService.getBoard(bd_num);
		List<FileVO> filelist = boardService.getFileList(bd_num);
		
		//이번에는 컨트롤러에서 유저정보 체크를 함
		if(user!=null && board !=null && user.getMe_id().equals(board.getBd_me_id())) {
			System.out.println(filelist);
			mv.addObject("board",board);
			mv.addObject("fileList",filelist);
			mv.setViewName("/board/modify");
		}else {
		//유저정보가 일치하지 않을시 게시글 상세로 보냄
			mv.addObject("bd_num", bd_num);
			mv.setViewName("redirect:/board/detail");
		}
		return mv;
	}
	@RequestMapping(value="/modify", method = RequestMethod.POST)
	public ModelAndView boardModifyPOST(ModelAndView mv, BoardVO board
			,List<MultipartFile> files2, Integer [] fileNums) {
//		//게시판을 업데이트 함
		
		boardService.modifyBoard(board,files2, fileNums);
//		//번호에 맞는 게시글을 화면에 추가해줌
		mv.addObject("bd_num", board.getBd_num());
		mv.setViewName("redirect:/board/detail");
		return mv;
	}
	@RequestMapping(value = "/delete", method  = RequestMethod.GET)
	public ModelAndView boardDeleteGet(ModelAndView mv, Integer bd_num, HttpServletRequest request) {
		//로그인 회원 정보를 이용해 글쓴이를 확인하므로 로그인 세션의 유저정보 가지고 와야 함
		MemberVO user = (MemberVO)request.getSession().getAttribute("user");
		boardService.deleteBoard(bd_num, user);
		mv.setViewName("redirect:/board/list");
		return mv;
	}
	@ResponseBody
	@RequestMapping("/download")
	public ResponseEntity<byte[]> downloadFile(String fileName)throws Exception{
//		String uploadPath = "D:\\JAVA_ODIA\\java_odia\\upload"; //업로드된곳
		String uploadPath = "C:\\Users\\MASTER\\Desktop\\java_odia\\upload"; //업로드된곳
	    InputStream in = null;
	    ResponseEntity<byte[]> entity = null;
	    try{
	        String FormatName = fileName.substring(fileName.lastIndexOf(".")+1);
	        HttpHeaders headers = new HttpHeaders();
	        in = new FileInputStream(uploadPath+fileName);

	        fileName = fileName.substring(fileName.indexOf("_")+1);
	        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
	        headers.add("Content-Disposition",  "attachment; filename=\"" 
				+ new String(fileName.getBytes("UTF-8"), "ISO-8859-1")+"\"");
	        entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in),headers,HttpStatus.CREATED);
	    }catch(Exception e) {
	        e.printStackTrace();
	        entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
	    }finally {
	        in.close();
	    }
	    return entity;
	}
	@ResponseBody
	@RequestMapping(value ="/likes")
	public String boardLikes(@RequestBody LikesVO likes, HttpServletRequest request){
		MemberVO user = (MemberVO)request.getSession().getAttribute("user");
	
	  return boardService.likes(likes,user);
	}
	@ResponseBody
	@RequestMapping(value ="/view/likes")
	public String boardViewLikes(@RequestBody LikesVO likes, HttpServletRequest request){
		MemberVO user = (MemberVO)request.getSession().getAttribute("user");
	
	  return boardService.viewLikes(likes,user);
	}
}
	
