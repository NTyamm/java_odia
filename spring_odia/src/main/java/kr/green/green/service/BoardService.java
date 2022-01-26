package kr.green.green.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import kr.green.green.pagination.Criteria;
import kr.green.green.vo.BoardVO;
import kr.green.green.vo.FileVO;
import kr.green.green.vo.MemberVO;

public interface BoardService {

	List<BoardVO> getBoardList(Criteria cri);

	BoardVO getBoard(Integer bd_num);
	//????이게맞ㄴㅏ?? 유저빼고 파일에 throws exception?
	void registerBoard(BoardVO board, List<MultipartFile> files2, MemberVO user)throws Exception;

	void modifyBoard(BoardVO board, List<MultipartFile> files2, Integer[] fileNums);

	void deleteBoard(Integer bd_num, MemberVO user);

	List<FileVO> getFileList(Integer bd_num);

	int getTotalCount(Criteria cri); //string을 의미전달의 용이성을 위해 type으로 변경

	void updateViews(Integer bd_num);







	

}
