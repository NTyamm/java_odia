package kr.green.spring.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.green.spring.dao.BoardDAO;
import kr.green.spring.vo.BoardVO;
import kr.green.spring.vo.MemberVO;

@Service
public class BoardServiceImp implements BoardService {

	@Autowired
	BoardDAO boardDao;
	

	@Override
	public void registerBoard(BoardVO board) {
		if(board == null || board.getBd_title()==null 
						 || board.getBd_contents()==null
						 || board.getBd_me_id()==null)
			return;
		boardDao.insertBoard(board);
	}


	@Override
	public List<BoardVO> getBoardList(String type) {
		return boardDao.getBoardList(type);
	}


	@Override
	public BoardVO getBoard(Integer bd_num) {
		//게시글 번호가 없거나 0이하이면 null을 반환
		if(bd_num==null || bd_num <= 0)
			return null;
		//아래 두 줄은 어딘가에 담았다가 보내는 거라 조금 비효율적...맨 아래 한줄이 빠르고 경제적
		//BoardVO board = boardDao.getBoard(bd_num);
		//return board
		return boardDao.getBoard(bd_num);
	}


	@Override
	public void deleteBoard(Integer bd_num, MemberVO user) {
		//유효하지 않은 게시글 번호이면 삭제할 필요 없음
		//번호가 null이거나 음수, 0인 경우
		if(bd_num==null || bd_num <=0)
			return;
		//게시글 번호와 일치하는 게시글을 가져옴
		BoardVO board = boardDao.getBoard(bd_num);
		
		//가져온 게시글이 null이면 삭제할 필요 없음
		if(board == null)
			return;
		//게시글 작성자와 로그인한 회원 아이디가 같은지 확인하여 다르면 삭제할 필요 없음
		if(!board.getBd_me_id().equals(user.getMe_id())) //equals로 비교해야 함
			return;
		//게시글을 삭제
		//게시글의 bd_del을 Y로 수정
		//다오에게 수정된 게시글을 업데이트하라고 시킴
		//board.Dao.게시글삭제(게시글번호);
		//1. 단순한 쿼리문이지만 재사용성이 낮음. 속성 두 개만 덮어쓰기
		boardDao.deleteBoard(bd_num);
		//2. 재사용성은 높지만 쿼리문이 복잡함(수정시에 더 잘 쓰일 업데이트문). 속성 전부 덮어쓰기
		/*
		board.setBd_del("Y");
		board.set_del_date(new Date());
		boardDao.updateBoard(board);
		*/
	}


	@Override
	public BoardVO getBoard(Integer bd_num, MemberVO user) {
		//게시글 번호가 유효한지 체크
		if(bd_num == null || bd_num <= 0)
			return null;
		//다오에게 게시글을 가져오라고 시킴
		BoardVO board = boardDao.getBoard(bd_num);
		//가져온 게시글이 있으면 작성자와 user 비교하여 같은 아이디인지 체크
		if(board == null|| !board.getBd_me_id().equals(user.getMe_id())) //equals로 비교해야 함
			return null;
		return board;
			
	}


	@Override
	public void updateBoard(BoardVO board) {
		//다오에게 게시글 번호와 일치하는 게시글을 가져오라고 시킴
		//게시글=다오.게시글가져오기(게시글번호)
		BoardVO dbBoard=boardDao.getBoard(board.getBd_num());
		//가져온 게시글의 제목과 내용을 board의 제목과 내용으로 덮어쓰기를 함
		dbBoard.setBd_title(board.getBd_title());
		dbBoard.setBd_contents(board.getBd_contents());
		//가져온 게시글의 수정일을 현재 시간으로 업데이트
		dbBoard.setBd_up_date(new Date());
		//다오에게 수정된 게시글 정보를 주면서 업데이트하라고 시킴
		boardDao.updateBoard(dbBoard);
	}

}
