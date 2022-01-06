package kr.green.spring.dao;

import org.apache.ibatis.annotations.Param;

import kr.green.spring.vo.MemberVO;

public interface MemberDAO {

	MemberVO getMember(@Param("me_id")String me_id);
	//회원가입
	//public void signup(MemberVO)......몰으겠음0105
	//서비스에서 크리에이트메소드하니까 생겼음! 그걸 수정해야함! @Param 붙여야함!0106

	void insertMember(@Param("user")MemberVO user);

	
	
	
}
