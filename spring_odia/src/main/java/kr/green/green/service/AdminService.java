package kr.green.green.service;

import java.util.List;

import kr.green.green.vo.MemberVO;

public interface AdminService {

	List<MemberVO> getMemberList();

	boolean updateAuthority(MemberVO member);

}
