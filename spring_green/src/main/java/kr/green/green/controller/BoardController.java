package kr.green.green.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.green.green.service.BoardService;
import kr.green.green.vo.BoardVO;
import kr.green.green.vo.MemberVO;

@Controller
//리퀘스트매핑이 들어가야 함-요청 URL을 어떤 메소드가 처리할지 결정함
@RequestMapping(value="/board")
public class BoardController {

	@Autowired //서비스 인터페이스 연결 필요
	BoardService boardService;
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public ModelAndView boardList(ModelAndView mv) {
		//VO를 이용해 리스트 정보 불러오기. VO 클래스 연결 필요
		List<BoardVO> list = boardService.getBoardList("일반");
		System.out.println(list);
		mv.addObject("list",list)
		  .setViewName("/board/list"); //세미콜론을 안 쓰고 mv에 묶을 수 있음
		return mv;
	}
	@RequestMapping(value="/detail")
	public ModelAndView boardDetail(ModelAndView mv, Integer bd_num) {
		mv.setViewName("/board/detail");
		//VO를 이용해 boardService에게 bd_num에 따른 board정보를 가져오게 시킴
		BoardVO board = boardService.getBoard(bd_num);
		mv.addObject("board",board);
		return mv;
	}
	@RequestMapping(value = "/register", method  = RequestMethod.GET)
	public ModelAndView boardRegisterGet(ModelAndView mv) {
		mv.setViewName("/board/register");
		return mv;
	}
	@RequestMapping(value="/register", method = RequestMethod.POST)
	public ModelAndView boardRegisterPOST(ModelAndView mv, BoardVO board, HttpServletRequest request) {
		//로그인 회원 정보를 이용해 글쓴이를 등록하므로 로그인 세션의 유저정보 가지고 와야 함
		MemberVO user = (MemberVO) request.getSession().getAttribute("user");
		//글쓴이를 로그인 세션의 유저 아이디로 설정함
		board.setBd_me_id(user.getMe_id());
		//공지사항이 아니기 때문에 "일반"으로 게시판 타입 지정해줘야 함
		board.setBd_type("일반");
		boardService.registerBoard(board);
		mv.setViewName("redirect:/board/list");
		return mv;
	}
}
