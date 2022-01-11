package kr.green.green.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.green.green.service.MemberService;
import kr.green.green.vo.MemberVO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
    MemberService memberService;
    
    @RequestMapping(value="/")
    public ModelAndView main(ModelAndView mv) throws Exception{
        mv.setViewName("/main/home");
        mv.addObject("setHeader", "타일즈테스트");
        //아래 코드는 연동 확인 후 지울 코드
        //abc123은 샘플 데이터에 있는 회원아이디
        return mv;
    }
    @RequestMapping(value="/signup", method = RequestMethod.GET)
    public ModelAndView signupGet(ModelAndView mv, MemberVO user){
    	System.out.println("/signup:get :");
    	mv.setViewName("/member/signup");
    	return mv;                                                                                                                                                                                                                                                                                                
    }
    @RequestMapping(value="/signup", method = RequestMethod.POST)
    public ModelAndView signupPost(ModelAndView mv, MemberVO user){
    	System.out.println("/signup:post :"+user); //로 테스트 먼저 하기
    	boolean isSignup=memberService.signup(user);
    	if(isSignup) {
    		mv.setViewName("redirect:/");
    	}else {
    		mv.setViewName("redirect:/signup");
    	}
    	return mv;
    }
}
