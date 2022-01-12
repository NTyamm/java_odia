package kr.green.green.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.green.green.dao.BoardDAO;
import kr.green.green.vo.BoardVO;

@Service
public class BoardServiceImp implements BoardService {
	
	@Autowired
	BoardDAO boardDao;

	@Override
	public List<BoardVO> getBoardList(String bd_type) {
		return boardDao.selectBoardList(bd_type);
	}

	@Override
	public BoardVO getBoard(Integer bd_num) {
		return null;//boardDao.selectBoad(bd_num);
	}

	@Override
	public void registerBoard(BoardVO board) {
		
		
	}

	 
}
