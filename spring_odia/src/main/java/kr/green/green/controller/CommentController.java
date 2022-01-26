package kr.green.green.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.green.green.pagination.Criteria;
import kr.green.green.pagination.PageMaker;
import kr.green.green.service.CommentService;
import kr.green.green.vo.CommentVO;
import kr.green.green.vo.MemberVO;

@RestController //레스트 컨트롤러는 ajax로만 올 수 있다. 클래스 아래에 @ResponseBody가 필요없음
public class CommentController {
	@Autowired
	CommentService commentService;
	
	@RequestMapping(value="/comment/insert")
	public String commentInsert(@RequestBody CommentVO comment, HttpServletRequest request) {
		MemberVO user = (MemberVO)request.getSession().getAttribute("user");
		if(commentService.insertComment(comment, user)) {
			return "true";
		}
		return "false";
	}
	@RequestMapping(value="/comment/list")
	public Map<String, Object> commentList(Integer co_bd_num, Integer page) {
		Criteria cri = new Criteria(page, 5);
		List<CommentVO> list = commentService.selectCommentList(co_bd_num, cri);
		Map<String, Object> map = new HashMap<String, Object>();
		
		int totalCount = commentService.selectTotalCount(co_bd_num);
		PageMaker pm = new PageMaker(totalCount,5,cri);
		map.put("pm", pm);
		map.put("list", list);
		return map;
	}
	@RequestMapping(value ="/comment/delete")
	public String commentDelete(Integer co_num, HttpServletRequest request){
		MemberVO user = (MemberVO)request.getSession().getAttribute("user");
		System.out.println(user);
		System.out.println(co_num);
	  return commentService.deleteComment(co_num, user);
	}
	
	@RequestMapping(value ="/comment/modify")
	public String commentModify(@RequestBody CommentVO comment, HttpServletRequest request){
		MemberVO user = (MemberVO)request.getSession().getAttribute("user");
	  return commentService.updateComment(comment, user);
	}
	
}
