package kr.green.spring.dao;

import org.apache.ibatis.annotations.Param;

import kr.green.spring.vo.MemberVO;

public interface MemberDAO {

	MemberVO getMember(@Param("me_id")String me_id);
	//회원가입
	//public void signup(MemberVO)......몰으겠음
}
