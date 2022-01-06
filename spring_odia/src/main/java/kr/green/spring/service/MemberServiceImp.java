package kr.green.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import kr.green.spring.dao.MemberDAO;
import kr.green.spring.vo.MemberVO;

@Service
public class MemberServiceImp implements MemberService {

	@Autowired
	MemberDAO memberDao;
	
	@Autowired
	BCryptPasswordEncoder passwordEncoder;                                    

	@Override
	public MemberVO login(MemberVO member) {
		if(member == null || member.getMe_id() == null)
			return null;
		MemberVO user = memberDao.getMember(member.getMe_id());
		//로그인에 성공하면 회원정보를 실패하면 null을 반환
		if(user == null)
			return null;
		//matches(원래 비번, 암호회된 비번) : 같으면(비번이 맞으면)
		if(passwordEncoder.matches(member.getMe_pw(), user.getMe_pw()))
			return user;
		return null;
	}

	@Override
	public boolean signup(MemberVO user) {
		//여기에... insert 하는 게 들어가야 할 거 같음0105 그게 아래 if 문임0106
		if(user == null)
			return false;
		if(user.getMe_id()==null)//필수항목인 아이디 null인지 체크
			return false;
		if(user.getMe_pw()==null)//필수항목인  비번 null인지 체크
			return false;
		if(memberDao.getMember(user.getMe_id()) != null) //아이디 중복 검사
			return false;
		//DB에 저장하기 전에 비밀번호 암호화해야함 memberDao.insertMember(user)이전에 암호화 넣어줘야 함
		//암호화된 비밀번호
		String encPw= passwordEncoder.encode(user.getMe_pw());
		user.setMe_pw(encPw);
		memberDao.insertMember(user);
		return true;
	}
	
}
