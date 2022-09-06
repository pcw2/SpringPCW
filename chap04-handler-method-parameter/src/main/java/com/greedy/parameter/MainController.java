package com.greedy.parameter;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	/* return 타입을 void로 하는 경우 viewResolver는 요청 주소 자체를 view name으로 해석하게 된다.*/
	@RequestMapping("/main")
	public void showMain() {
		
	}
}
