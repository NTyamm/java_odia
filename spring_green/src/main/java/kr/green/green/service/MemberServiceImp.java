package kr.green.green.service;

import java.util.List;

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
	private JavaMailSender mailSender;
	
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
	public String idCheck(String me_id) {
		MemberVO user = memberDao.selectMember(me_id);
		if(user == null)
			return "true";
		else
			return "false";
	}

	@Override
	public MemberVO updateMember(MemberVO inputUser, MemberVO user) {
		if(inputUser == null || user == null || inputUser.getMe_id() == null || inputUser.getMe_id().length() == 0)
			return null;
		//아이디 덮어쓰기 
		inputUser.setMe_id(user.getMe_id());
		//권한 덮어쓰기
		inputUser.setMe_authority(user.getMe_authority());
		//비밀번호 덮어쓰기
		if(inputUser.getMe_pw()==null || inputUser.getMe_pw().length()==0) {
			inputUser.setMe_pw(user.getMe_pw());
		}else {
			String encPw = passwordEncoder.encode(inputUser.getMe_pw());
			inputUser.setMe_pw(encPw);
		}
		//주소 덮어쓰기
		if(inputUser.getMe_address() == null || inputUser.getMe_address().length()==0) {  
		}
		memberDao.updateMember(inputUser);
		return inputUser;
	}

	@Override
	public String selectIdByEmail(MemberVO member) {
		if(member == null)
			return "";
		return memberDao.selectIdByEmail(member);
	}

	@Override
	public String sendPassword(MemberVO member) {
		if(member == null)
			return "fail";
		//회원정보를 가져옴(id를 가져옴)
		MemberVO user = memberDao.selectMember(member.getMe_id());
		//가져온 회원 정보의 이메일과 입력한 이메일을 비교하여 같은지 확인
		if(user==null|| !user.getMe_email().equals(member.getMe_email()))
			return"fail";
		//새 비번 생성 > Regex로 조건을 걸어 랜덤조합
		String newPw = createRandomPw(6);
		
		//새 비번 암호화
		String encPw= passwordEncoder.encode(newPw);
		//새 비번 DB에 저장
		user.setMe_pw(encPw);
		memberDao.updateMember(user);
		//새 비번 이메일 전송
		String contents = user.getMe_id()+"님의 임시 비밀번호는" + newPw + "입니다";
		String from = "mi_dios@naver.com";
		String title = "임시 비밀번호 발급";
		if(!sendEmail(from,user.getMe_email(),title,contents))//컨트롤러에서 뭔가 놓쳤나?
			return "error";
		return "ok";
	}
	private boolean sendEmail(String from, String to, String title, String contents) {
		try {
     MimeMessage message = mailSender.createMimeMessage();
     MimeMessageHelper messageHelper 
        = new MimeMessageHelper(message, true, "UTF-8");
     messageHelper.setFrom(from);  // 보내는사람 생략하거나 하면 정상작동을 안함
     messageHelper.setTo(to);     // 받는사람 이메일
     messageHelper.setSubject(title); // 메일제목은 생략이 가능하다
     messageHelper.setText(contents);  // 메일 내용
     mailSender.send(message);
		
		}catch(Exception e){
      System.out.println(e);
      return false;
		}	
		return true;
	}
	
	//랜덤 비번 만드는 메소드
	private String createRandomPw(int maxSize) {
		String newPw=""; //빈 문자열로 만들어야 아래서 =+으로 문자열을 이어붙일 수 있따.
		if(maxSize <= 0)
			return "";
		for(int i =1; i<=maxSize; i++) {
			//62= 26(영소문자)+26(영대문자)+10(숫자 0~9)
			int r = (int)(Math.random()*62);
			if(r < 10) {
				newPw += (char)('0'+r);
			}else if(r < 36) {
				newPw += (char)('a'+r-10);//앞선 숫자0~9의 갯수 10을 빼줌
			}else {
				newPw +=(char)('A'+r-36);//앞선 숫자 0~9와 영소문자 갯수 26개를 빼줌
			}
		}
		return newPw;
	}

	@Override
	public List<MemberVO> getUserList(MemberVO user) {
		if(user == null)
			return null;
		if(!user.getMe_authority().equals("슈퍼 관리자"))
			return null;
		return memberDao.selectMemberList();
	}

	@Override
	public boolean changeAuthority(MemberVO member, MemberVO user) {
		if(member == null || user == null)
			return false;
		if(!user.getMe_authority().equals("슈퍼 관리자"))
			return false;
		//바꾸려는 권한이 슈퍼관리자인 경우
		if(member.getMe_authority().equals("슈퍼 관리자"))
			return false;
		//아이디와 일치하는 회원 정보를 가져옴
		MemberVO dbUser = memberDao.selectMember(member.getMe_id());
		//해당 회원의 권한이 슈퍼 관리자인지 아닌지 확인
		if(dbUser == null || dbUser.getMe_authority().equals("슈퍼 관리자"))
			return false;
		//슈퍼관리자라면  false를 리턴
		dbUser.setMe_authority(member.getMe_authority());
		memberDao.updateMember(dbUser);
		return true;
	}

	@Override
	public void insertAutoLogin(MemberVO user) {
		if(user == null)
			return;
		memberDao.updateSession(user);
		
	}

	@Override
	public MemberVO selectIdBySessionId(String me_session_id) {
		return memberDao.selectMemberBySessionId(me_session_id);
	}
}
