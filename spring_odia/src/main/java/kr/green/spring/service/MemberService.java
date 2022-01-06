package kr.green.spring.service;

import kr.green.spring.vo.MemberVO;

public interface MemberService {

	MemberVO login(MemberVO member);
	//회원가입
	boolean signup(MemberVO user); //return type을 불리언으로 하는 이유는 아이디중복등으로 가입실패되는 경우가 있어서
}
