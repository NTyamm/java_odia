package kr.green.spring.service;

import kr.green.spring.vo.MemberVO;

public interface MemberService {

	MemberVO login(MemberVO member);
	//회원가입
	MemberVO signup(MemberVO member);
}
