package kr.green.green.service;

import java.util.List;

import kr.green.green.pagination.Criteria;
import kr.green.green.vo.CommentVO;
import kr.green.green.vo.MemberVO;

public interface CommentService {

	boolean insertComment(CommentVO comment, MemberVO user);

	List<CommentVO> selectCommentList(Integer co_bd_num, Criteria cri);

	int selectTotalCount(Integer co_bd_num);

	String deleteComment(Integer co_num, MemberVO user);

	String updateComment(CommentVO comment, MemberVO user);

}
