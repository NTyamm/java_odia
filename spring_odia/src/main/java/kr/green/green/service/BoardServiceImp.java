package kr.green.green.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kr.green.green.dao.BoardDAO;
import kr.green.green.utils.UploadFileUtils;
import kr.green.green.vo.BoardVO;
import kr.green.green.vo.FileVO;
import kr.green.green.vo.MemberVO;

@Service
public class BoardServiceImp implements BoardService {
	
	@Autowired
	BoardDAO boardDao;
	//업로드할 경로. 학원과 집에서 다르게 설정해야 함
	String uploadPath = "C:\\Users\\MASTER\\Desktop\\java_odia";

	@Override
	public List<BoardVO> getBoardList(String bd_type) {
		return boardDao.selectBoardList(bd_type);
	}

	@Override
	public BoardVO getBoard(Integer bd_num) {
		if(bd_num == null || bd_num <= 0)
			return null;
		return boardDao.selectBoard(bd_num);
	}

	@Override //유저정보....왜빠지는데...이게...이렇게수정이?? 체인지도 자동으로 안되고????직접쳐서????
	public void registerBoard(BoardVO board, List<MultipartFile> files) throws Exception {
		if(board == null
				|| board.getBd_title() == null
				|| board.getBd_contents() == null
				|| board.getBd_me_id() ==null)
			return;
		boardDao.insertBoard(board);
		if (files == null)
			return;
		for(MultipartFile tmpFile : files) {
			//첨부파일 업로드및 DB에 저장
			//첨부파일이 있고, 첨부파일 이름이 1글자 이상인 경우에만 업로드
			if(tmpFile != null && tmpFile.getOriginalFilename().length() !=0) {
				//서버에 업로드
				String path = UploadFileUtils.uploadFile(
					uploadPath, tmpFile.getOriginalFilename(), tmpFile.getBytes());
				//DB에 저장
				FileVO fileVo = 
				new FileVO(tmpFile.getOriginalFilename(), path, board.getBd_num());
				System.out.println(fileVo);
				boardDao.insertFile(fileVo);
			}
		}		
		
	}

	@Override
	public void modifyBoard(BoardVO board, MemberVO user) {
		if(board == null || user == null || board.getBd_num() <= 0)
			return;
		BoardVO dbBoard = boardDao.selectBoard(board.getBd_num());
		if(dbBoard == null)
			return;
		if(!dbBoard.getBd_me_id().equals(user.getMe_id()))
			return;
		boardDao.updateBoard(board);
		
	}

	@Override
	public void deleteBoard(Integer bd_num, MemberVO user) {
		if(bd_num == null || bd_num <= 0)
			return;
		BoardVO board = boardDao.selectBoard(bd_num);
		if(board == null)
			return;
		if(user != null && board.getBd_me_id().equals(user.getMe_id()))
			boardDao.deleteBoard(bd_num);
	}

	@Override
	public List<FileVO> getFileList(Integer bd_num) {
		if(bd_num == null || bd_num <=0)
			return null;
		return boardDao.selectFileList(bd_num);
	}
	 
}
