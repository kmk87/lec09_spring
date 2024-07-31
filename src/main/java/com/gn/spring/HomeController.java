package com.gn.spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	
	// 클라이언트가 요청한 서비스 주소와 메소드를 연결
	// 요청 메소드
	// 구현 기능에 따라서 어노테이션(@), 반환형(String), 매개변수() 달라짐
	// 메소드명은 연결에 영향없음
	// http://localhost:8090
	// http://localhost:8090/  자바는 둘을 다르게 구분함. 그래서 벨류값의 경로에
	// 빈문자열과 / 넣은것임
	@RequestMapping(value= {"","/"},method=RequestMethod.GET)
	public String home() {
		// /WEB-INF/views/home.jsp
		return "home";
	}
	
	
	
}
