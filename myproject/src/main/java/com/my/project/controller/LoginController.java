package com.my.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

	@GetMapping("/member/login")
	public String login() {
		return "login/member_login";
	}
	
	
}
