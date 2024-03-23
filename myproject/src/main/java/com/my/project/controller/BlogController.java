package com.my.project.controller;

import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.my.project.dto.MemberSecurityDTO;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class BlogController {

	@GetMapping("/member/blog")
	public String myBlog(HttpServletRequest req, @AuthenticationPrincipal MemberSecurityDTO member) {
		if (member == null) {
			req.setAttribute("msg", "로그인 후 이용가능합니다.");
			req.setAttribute("url", "/main");
			return "message";
		}
		return "blog/myblog";
	}
}
