package kr.green.green.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    MemberService memberService;
    
    @RequestMapping(value="/")
    public ModelAndView main(ModelAndView mv) throws Exception{
        mv.setViewName("/main/home");
        mv.addObject("setHeader", "타일즈테스트");
        //아래 코드는 연동 확인 후 지울 코드
        //abc123은 샘플 데이터에 있는 회원아이디
        MemberVO user = memberService.test("abc123");
        System.out.println(user);
        return mv;
    }

}
