package kr.green.green.service;

import kr.green.green.vo.MemberVO;

public interface MemberService {

	boolean signup(MemberVO user);

	MemberVO login(MemberVO user);

	boolean idDuplicated(String id);

	MemberVO updateMember(MemberVO input, MemberVO user);

	String findId(MemberVO member);

	String findPw(MemberVO member);

	void updateAutoLogin(MemberVO user);

	MemberVO selectMemberBySessionId(String value);

	

}
