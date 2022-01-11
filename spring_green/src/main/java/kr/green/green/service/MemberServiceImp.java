package kr.green.green.service;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
 
import kr.green.green.dao.MemberDAO;
import kr.green.green.vo.MemberVO;
 
@Service
public class MemberServiceImp implements MemberService {
    
	@Autowired
    MemberDAO memberDao;
	BCryptPasswordEncoder passwordEncoder;


	@Override
	public boolean signup(MemberVO user) {
		if(user == null) 
			return false;
		if(user.getMe_id().trim().length() == 0 || user.getMe_id() == null) //필수항목 아이디 체크
			return false;
		if(user.getMe_pw().trim().length() == 0 || user.getMe_pw() == null) //필수항목 비번 체크
			return false;
		//그리고 아이디 중복검사
		if(memberDao.getMember(user.getMe_id()) != null)
			return false;
		//비밀번호 암호화
		String encPw=passwordEncoder.encode(user.getMe_pw());
		user.setMe_pw(encPw);
		//dao에게 유저정보 insert
		memberDao.insertMember(user);
		return true;
	}
}