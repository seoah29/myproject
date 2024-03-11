package com.my.project;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyMainController {

	@GetMapping(value = {"/", "main"})
	public String mainCon() {
		return "main/main";
	}
}
