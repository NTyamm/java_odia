package kr.green.spring.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.green.spring.vo.MemberVO;
//@Controller가 있어야 URL을 분석하여 처리. 이게 없다면 리퀘스트 매핑을 열심히 작업해도 의미가 없다.
@Controller
public class HomeController {
	//URL을 확인하는 곳, 필수
	//value는 localhost:8080/패키지명을 제외한 부분
	//method는 전달방식, GET, POST, 생략하면 둘 다
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home(ModelAndView mv) {
		//화면 파일명 확장자는 여기서 선택하는 게 아님
		//확장자는 servlet-context.xml에서 설정
		//단, views 폴더에는 jsp만 가능
		//html을 화면으로 쓰려면 src/main/resources 폴더에 넣어야 함
		mv.setViewName("home");
		//화면으로 데이터를 보낼 때 addObject를 사용
		//addObject("화면에서 사용할 이름", 데이터);
		mv.addObject("serverTime", "데이터" );
		
		return mv;
	}
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	//int는 null을 허용하지 않고 Integer는 허용하기 때문에 Integer가 더 안전
	public ModelAndView testGet(ModelAndView mv, Integer num, String name) {
		mv.setViewName("home");
		//addObject("화면에서 사용할 이름", 데이터);
		mv.addObject("serverTime", "데이터" );
		System.out.println("/test : num =" + num + ", name = " + name);
		return mv;
	}
	@RequestMapping(value = "/test/form", method = RequestMethod.GET)
	//int는 null을 허용하지 않고 Integer는 허용하기 때문에 Integer가 더 안전
	public ModelAndView testFormGet(ModelAndView mv, Integer num, String name) {
		mv.setViewName("home");
		//addObject("화면에서 사용할 이름", 데이터);
		mv.addObject("serverTime", "데이터" );
		System.out.println("/test/form:get : num =" + num + ", name = " + name);
		return mv;
	}
	@RequestMapping(value = "/test/form", method = RequestMethod.POST)
	//int는 null을 허용하지 않고 Integer는 허용하기 때문에 Integer가 더 안전
	public ModelAndView testFormPost(ModelAndView mv, Integer num, String name) {
		mv.setViewName("home");
		//addObject("화면에서 사용할 이름", 데이터);
		mv.addObject("serverTime", "데이터" );
		System.out.println("/test/form:post : num =" + num + ", name = " + name);
		return mv;
	}

	
	@RequestMapping(value = "/test2", method = RequestMethod.GET)
	public ModelAndView test2Cal(ModelAndView mv, Integer num1, Integer num2) {
		System.out.println("num1 = "+num1 +", num2 = "+num2);
		Integer res = null;
		if(num1 !=null && num2 !=null) {
			res= num1+num2;
		}
		mv.addObject("result",res);
		mv.addObject("num1",num1);
		mv.addObject("num2",num2);
		mv.setViewName("test2");
		return mv;
	}
	
	@RequestMapping(value = "/test3", method = RequestMethod.GET)
	public ModelAndView test2Cal(ModelAndView mv, MemberVO member) {
		System.out.println("/test3 : "+ member);
		mv.setViewName("test3");
		return mv;
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView loginGet(ModelAndView mv) {
		System.out.println("/login:get :");
		mv.setViewName("login");
		return mv;
	}
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView loginPost(ModelAndView mv, MemberVO member) {
		System.out.println("/login:post :"+member);
		mv.setViewName("login");
		return mv;
	}
}
//default 접근제한자 : 나 + 같은 패키지
//class A{}
	//test3에서 회원정보를 관리할 A클래스를 여기에서 호출 가능하지만 범용성을 높이기 위해 패키지를 새로 만드는 게 좋음
	//다른 패키지에 있으니 ctrl+shift+O로 MemberVO를 import
