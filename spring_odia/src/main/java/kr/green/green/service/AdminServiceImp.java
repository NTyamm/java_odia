package kr.green.green.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.green.green.dao.MemberDAO;
import kr.green.green.vo.MemberVO;

@Service
public class AdminServiceImp implements AdminService {
	@Autowired
	MemberDAO memberDao;
	
	@Override
	public List<MemberVO> getMemberList() {
		return memberDao.selectMemberList();
	}

	@Override
	public boolean updateAuthority(MemberVO member) {
		System.out.println("1 : " +member);
		if(member == null || member.getMe_id() == null || member.getMe_authority().equals("슈퍼 관리자") || member.getMe_authority() == null)
			return false;
		MemberVO dbUser = memberDao.selectMember(member.getMe_id());
		System.out.println("2 : " +dbUser);
		if(dbUser == null)
			return false;
		dbUser.setMe_authority(member.getMe_authority());
		memberDao.updateMember(dbUser);
		return true;
	}

}
