package kr.green.green.service;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import kr.green.green.dao.MemberDAO;
import kr.green.green.vo.MemberVO;

@Service
public class MemberServiceImp implements MemberService {
	
	@Autowired
	MemberDAO memberDao;
	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	@Autowired
	JavaMailSender mailSender;
	
	@Override
	public boolean signup(MemberVO user) {
		//회원가입 안되는 경우 확인해서 회원가입 진행
		if(user == null)
			return false;
		//아이디 가능한지 확인
		if(user.getMe_id() == null || user.getMe_id().trim().length() == 0)
			return false;
		//비밀번호 가능한지 확인
		
		//성별 가능한지 확인
		
		//가능하다면 회원가입을 진행
		//비밀번호 암호화
		String encPw = passwordEncoder.encode(user.getMe_pw());
		user.setMe_pw(encPw);
		memberDao.insertMember(user);
		return true;
	}

	@Override
	public MemberVO login(MemberVO user) {
		if(user== null || user.getMe_id()==null 
			|| user.getMe_id().trim().length() == 0)
			return null;
		MemberVO dbUser = memberDao.selectMember(user.getMe_id());
		if(dbUser == null)
			return null;
		if(!passwordEncoder.matches(user.getMe_pw(), dbUser.getMe_pw()))
			return null;
		return dbUser;
	}

	@Override
	public boolean idDuplicated(String id) {
		return false;
	}

	@Override
	public MemberVO updateMember(MemberVO input, MemberVO user) {
		if(input == null || user == null)
			return null;
		if(input.getMe_name()== null 
				|| input.getMe_birth()==null 
				|| input.getMe_gender() == null)
			return null;
		
		input.setMe_id(user.getMe_id());//수정할 유저의 아이디(기본키)를 정해서...
		System.out.println(input);
		if(input.getMe_pw()==null || input.getMe_pw().length() == 0) {
			input.setMe_pw(user.getMe_pw());
		}else {
			String encPw = passwordEncoder.encode(input.getMe_pw());
			input.setMe_pw(encPw); //비밀번호 암호화 필수필수
		}
		if(input.getMe_address()==null || input.getMe_address().length() == 0) {
			input.setMe_address(user.getMe_address());
		}
		memberDao.updateMember(input);
		return input;
	}

	@Override
	public String findId(MemberVO member) {
		if(member == null) //입력한 회원정보
			return "";
		MemberVO user = memberDao.findMember(member);
		if(user == null) //db에 있는 회원정보
			return "";
		return user.getMe_id();
	}

	@Override
	public String findPw(MemberVO member) {
		//예외처리
		if(member == null)
			return "false";
		//회원정보를 가져옴
		MemberVO user = memberDao.selectMember(member.getMe_id());
		//회원정보가 없으면 종료
		if(user == null || !user.getMe_email().equals(member.getMe_email()))
			return "false";
		//임시 비밀번호 생성
		String newPw = createRandomPw(6);
		//생성된 비밀번호를 DB에 저장(암호화 시켜서 저장)
		String encPw = passwordEncoder.encode(newPw);
		user.setMe_pw(encPw);
		memberDao.updateMember(user);
		//이메일로 새 비밀번호를 전송(암호화 안 된 비번 전송)
		
    String setfrom = "oobob.aloo@gmail.com"; //아무거나 뭐라도 입력을 해야 발송이 됨         
    String tomail  = member.getMe_email();     // 받는 사람 이메일
    String title   = "임시 비밀번호 안내";      // 제목
    String content = "임시 비밀번호는"+newPw+"입니다";    // 내용

    try {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper messageHelper 
            = new MimeMessageHelper(message, true, "UTF-8");

        messageHelper.setFrom(setfrom);  // 보내는사람 생략하거나 하면 정상작동을 안함
        messageHelper.setTo(tomail);     // 받는사람 이메일
        messageHelper.setSubject(title); // 메일제목은 생략이 가능하다
        messageHelper.setText(content);  // 메일 내용

        mailSender.send(message);
    } catch(Exception e){
        System.out.println(e);
        return "error";
    }
    return "true";
	}
	private String createRandomPw(int maxSize) {
		String newPw="";
		//maxSize 갯수로 이루어진 비번으로, 영어와 숫자로 이루어짐
		//a~z,A~z,0~9: 62
		for(int i = 0; i<maxSize; i++) {
		//랜덤 수를 생성(0~61)
			int max=61, min=0;
			int r = (int)(Math.random() * (max-min + 1) + min); //외울필욘 없고 어디 적어두고 쓰면 되는 공식
			//int r=(int)(Math.random() * 62); //이렇게 적어도 되긴 함...
			//랜덤 수가 0~9이면 문자 0~9
			if(0 <= r && r <= 9) {
				newPw +=(char)('0'+r);//해당하는 유니코드에 맞는 문자가 출력됨
				//ex) (char)('a'+1) -> 'b'
			}else if(r <= 35){
				//랜덤 수가 10~35이면 문자 a~z
				newPw += (char)('a'+(r-10));
			}else if(r <= 61) {
			//랜덤 수가 36~61이면 문자 A~Z
				newPw += (char)('a'+(r-36));
			}
		}
		return newPw;
	}

	@Override
	public void updateAutoLogin(MemberVO user) {
		if(user == null)
			return;
		memberDao.updateAutoLogin(user);
	}

	@Override
	public MemberVO selectMemberBySessionId(String me_session_id) {
		return memberDao.selectMemberBySessionId(me_session_id);
	}

}
