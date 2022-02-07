package kr.green.green.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import kr.green.green.vo.MemberVO;

public interface MemberDAO {

	void insertMember(@Param("user")MemberVO user);

	MemberVO selectMember(@Param("me_id")String me_id);

	void updateMember(@Param("user")MemberVO input);

	MemberVO findMember(@Param("user")MemberVO member);

	List<MemberVO> selectMemberList();

	void updateAutoLogin(@Param("user")MemberVO user);

	MemberVO selectMemberBySessionId(@Param("me_session_id")String me_session_id);
	//요소가 2개 이상일 경우 무조건 @Param을 붙여야 한다. 멤버변수가 하나뿐이라면 @Param이 없어도 정상작동한다.


}
