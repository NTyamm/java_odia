package kr.green.green.interceptor;

import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.green.green.service.MemberService;
import kr.green.green.vo.MemberVO;

public class LoginInterceptor extends HandlerInterceptorAdapter  {
	
	@Autowired
	MemberService memberService;
	
	@Override
	public void postHandle(
	    HttpServletRequest request, 
	    HttpServletResponse response, 
	    Object handler, 
	    ModelAndView modelAndView)
	    throws Exception {
	    ModelMap modelMap = modelAndView.getModelMap();
	    MemberVO user = (MemberVO)modelMap.get("user");
	    
	    if(user != null) {
	    	//세션에 user 정보를 추가
    		HttpSession session = request.getSession();
    		//자동로그인을 체크했으면
    		if(user.getMe_auto_login() != null) {
    			//쿠키 생성(이름: loginCookie, 값: 세션아이디
    			Cookie cookie = new Cookie("loginCookie", session.getId());
    			//쿠키 기본 경로 설정
    			cookie.setPath("/");
    			//쿠키 유지시간 설정
    			int day = 7;
    			int session_limit_second = 60 * 60 * 24 * day;//일을 초로 계산
    			cookie.setMaxAge(session_limit_second);
    			//쿠키를 response에 추가
    			response.addCookie(cookie);
    			//DB 회원 정보에 쿠키에 저장된 session_id와 session 유지시간을 업데이트
    			//day(7)후의 날짜
    			Date session_limit = new Date(System.currentTimeMillis()+1000*session_limit_second);
    			user.setMe_session_id(session.getId());
    			user.setMe_session_limit(session_limit);
    			memberService.updateAutoLogin(user);
    			//
    		}
        session.setAttribute("user", user);
	    }
	}
}
