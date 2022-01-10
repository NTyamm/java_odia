package kr.green.spring.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class MemberInterceptor extends HandlerInterceptorAdapter{
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response,
			Object handler)
		    throws Exception{
		//세션에 있는 회원정보를 가져옴. 세션에 user로 저장했기에 user를 가져옴
		Object user = request.getSession().getAttribute("user");
		//세션에 회원정보가 없으면 -> 로그인을 안했으면
		if(user ==null) {
			response.sendRedirect(request.getContextPath()+"/login");
			//가려던 길로 가지 않고 다른 url로 가려고 할 경우
			return false;
		}
		//가던 길로 보낼 경우
		return true;
	}
}
