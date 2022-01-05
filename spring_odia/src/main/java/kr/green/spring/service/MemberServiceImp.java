package kr.green.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.green.spring.dao.MemberDAO;
import kr.green.spring.vo.MemberVO;

@Service
public class MemberServiceImp implements MemberService {

	@Autowired
	MemberDAO memberDao;

	@Override
	public MemberVO login(MemberVO member) {
		if(member == null || member.getMe_id() == null)
			return null;
		MemberVO user = memberDao.getMember(member.getMe_id());
		System.out.println(user);
		return null;
	}

	@Override
	public MemberVO signup(MemberVO member) {
		//여기에... insert 하는 게 들어가야 할 거 같음 아무래도 그렇지 않으면 큰일날 거 같음
		return null;
	}
	
}
