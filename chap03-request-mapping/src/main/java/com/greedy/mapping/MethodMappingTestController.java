package com.greedy.mapping;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/* DispatcherServlet은 웹 요청을 받는 즉시 @Controller가 달린 컨트롤러 클래스에 처리를 위임한다.
 * 그 과정은 컨트롤러 클래스의 핸들러 메소드에 선언 된 다양한 @RequestMapping 설정 내용에 따른다.
 * */
@Controller
public class MethodMappingTestController {

	@RequestMapping("/menu/regist")
	public String registMenu(Model model) {
		model.addAttribute("message", "신규 메뉴 등록용 핸들러 메소드 호출함");
		
		return "mappingResult";
	}
}
