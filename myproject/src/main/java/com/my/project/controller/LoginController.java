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
	
	@GetMapping("/id/find")
	public String idCheck() {
		return "login/member_id";
	}
	
	@GetMapping("/passwd/find")
	public String passwdCheck() {
		return "login/member_passwd";
	}
	
	@GetMapping("/myPage")
	public String myPage() {
		return "mypage/mypage";
	}
}
