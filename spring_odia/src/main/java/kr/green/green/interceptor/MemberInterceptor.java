package kr.green.green.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class MemberInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, 
			HttpServletResponse response, 
			Object handler)
			throws Exception {
		//세션에 있는 회원정보 가져오기
		Object user = request.getSession().getAttribute("user");
		if(user == null) {
			//회원정보가 없을 경우 로그인 화면으로 돌려보내기
			response.sendRedirect(request.getContextPath()+"/login");
			return false;
		}
		//회원정보가 있을 경우 진행시키기
		return true;
	}
}

