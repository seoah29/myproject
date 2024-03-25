package com.my.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.my.project.service.MemberService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/member")
public class LoginController {
	
	@Autowired
    private MemberService memberService;

    @Autowired
    private PasswordEncoder passwordEncoder;

	@GetMapping("/login")
	public String login() {
		return "login/member_login";
	}
	
//	@PostMapping("/login")
//	public String login(HttpServletRequest req) {
//		return "main/main";
//	}
}
