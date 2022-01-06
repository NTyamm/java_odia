package kr.green.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.green.spring.service.MemberService;
import kr.green.spring.vo.MemberVO;
//@Controller가 있어야 URL을 분석하여 처리
@Controller
public class HomeController {
	
	@Autowired
	MemberService memberService;
	
	//URL을 확인하는 곳, 필수
	//value는 localhost:8080/패키지명을 제외한 부분
	//method는 전달 방식, GET,POST, 생략하면 둘다
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView homeGet(ModelAndView mv) {
		
		mv.setViewName("/main/home");
		//화면으로 데이터를 보낼때 addObject를 사용
		//addObject("화면에서 사용할 이름", 데이터);
		mv.addObject("serverTime", "데이터" );
		
		return mv;
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView loginGet(ModelAndView mv) {
		System.out.println("/login:get :");
		mv.setViewName("/member/login");
		return mv;
	}
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView loginPost(ModelAndView mv, MemberVO member) {
		System.out.println("/login:post :" + member);
		MemberVO user = memberService.login(member);
		System.out.println(user);
		mv.setViewName("/member/login");
		return mv;
	}
	
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public ModelAndView signupGet(ModelAndView mv, MemberVO user) {
		System.out.println("/signup:get :");
		mv.setViewName("/member/signup");
		mv.addObject("user", user);//일회성 add임. 그래서 세션을 이용해 세션이 유지되는 동안 로그인 유지되게 함
		return mv;
	}
	
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public ModelAndView signupPost(ModelAndView mv, MemberVO user) {
		//MemberVO user = new MemberVO();
		//user.setMe_id(me_id);
		//user.setMe_ibirth(me_birth);
		System.out.println("/signup:post :" + user);
		if(memberService.signup(user)) {
			mv.setViewName("redirect:/");
		}else {

			mv.setViewName("redirect:/signup");
		}
		 
		return mv;
	}
}



