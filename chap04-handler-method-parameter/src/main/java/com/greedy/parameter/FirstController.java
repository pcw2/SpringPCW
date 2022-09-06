package com.greedy.parameter;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/first/*")
public class FirstController {
	
	/* GET 방식의 /first/regist 요청이 들어오면 /first/regist 뷰로 위임한다.
	 * views의 하위 경로를 요청 */
	@GetMapping("regist")
	public void regist() {

	}
	/* 핸들러 메소드에 파라미터로 특정 몇가지 타입을 선언하게 되면 핸들러 메소드 호출시 인자로 값을 전달해준다.*/
	
	/* 1. HttpServletRequest를 매개변수로 선언하여 파라미터로 전달 받은 값 꺼내기
	 * 	핸들러 메소드 매개변수로 HttpServletResponse도 사용 가능하다.
	 *	상위 타입인 ServletRequest, ServletResponse도 사용 가능하다. */
	@PostMapping("regist")
	public String registMenu(HttpServletRequest request, Model model) {
		
		
		String name = request.getParameter("name");
		int price = Integer.parseInt(request.getParameter("price"));
		int categoryCode = Integer.parseInt(request.getParameter("categoryCode"));
		
		String message = name +"을(를) 신규 메뉴 목록의 " + categoryCode + "번 카테고리에 "+ price +"원으로 등록하였습니다.";
		model.addAttribute("message",message);
		
		return "first/messagePrinter";
	}
	
	@GetMapping("modify")
	public void modify() {}
	
	/* 2. @RequestParam으로 값 꺼내기
	 * 요청 파라미터를 매핑하여 호출 시 값을 넣어주는 어노테이션으로 @PathVariable 처럼 변수 앞에 작성한다.
	 * form name 속성 값과 매개변수의 이름이 다른 경우 @RequestParam("name")을 설정하면 된다. 
	 * 또한 어노테이션은 생략 가능하지만 명시적으로 작성하는 것이 의미 파악에 쉽다.
	 * 
	 * 전달하는 form의 name 속성이 일치하는 것이 없는 경우 400 - 잘못 된 요청 에러가 발생하는데
	 * required 속성을 false로 설정하면 해당 name 값이 존재하지 않아도 null로 처리하며 에러가 발생하지 않는다.
	 * (기본 값이 true이기 때문에 설정하지 않으면 에러가 발생한다. )
	 * @RequestParam(required = false)
	 * 
	 * 값이 넘어오지 않게 되면 ""와 같은 빈 문자열이 넘어오게 되는데, 이 때 parsing 관련 에러가 발생 할 수 있다.(400 - 잘못된 요청)
	 * 값이 넘어오지 않는 경우 defaultValue를 이용하면 기본 값을 설정할 수 있다. 
	 * */
	@PostMapping("modify")
	public String modifyMenuPrice(Model model,  String modifyName, int modifyPrice) {
		
		String message = modifyName + "메뉴의 가격을 " + modifyPrice + "원으로 변경하였습니다.";
		model.addAttribute("message" , message);
		
		return "first/messagePrinter";
	}
	
	/* 파라미터가 여러 개인 경우 맵으로 한 번에 처리 할 수 있다.
	 * 이 때 맵의 키는 form의 name 속성 값이 된다.*/
	@PostMapping("modifyAll")
	public String modifyMenu(Model model,@RequestParam Map<String, String> parameters) {
		
		String modifyName = parameters.get("modifyName");
		int modifyPrice = Integer.parseInt(parameters.get("modifyPrice"));
		
		String message = "메뉴의 이름을 " + modifyName + "(으)로, 가격을 " + modifyPrice + "원으로 변경하였습니다.";
		model.addAttribute("message" , message);
		
		return "first/messagePrinter";
	}
	
}
