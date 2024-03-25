package com.my.project.controller;

import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.my.project.dto.MemberSecurityDTO;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/member/blog")
public class BlogController {

	@GetMapping("")
	public String myBlog(HttpServletRequest req, @AuthenticationPrincipal MemberSecurityDTO member) {
		System.out.println(member.getMemberId());
		if (member == null) {
			req.setAttribute("msg", "로그인 후 이용가능합니다.");
			req.setAttribute("url", "/main");
			return "message";
		}
		return "blog/myblog";
	}
	
	@GetMapping("/post")
	public String myblogUpload(HttpServletRequest req) {
		return "blog/upload";
	}
	
	@PostMapping("/post")
	public String myblogUpload() {
		return "message";
	}
	
}
