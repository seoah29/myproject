package com.my.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class LoginController {

	@GetMapping("/member/login")
	public String login() {
		return "login/member_login";
	}
	
	@PostMapping("/member/login")
	public String login(HttpServletRequest req) {
		return "main/main";
	}
}
