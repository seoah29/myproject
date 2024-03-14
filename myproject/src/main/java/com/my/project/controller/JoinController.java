package com.my.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.my.project.dto.MemberDTO;
import com.my.project.service.MemberService;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class JoinController {
	
	private final MemberService memberService;

	@GetMapping("member/join")
	public String join() {
		return "login/member_join";
	}
	
	@PostMapping("/member/join")
	public String join(HttpServletRequest req) {
		MemberDTO dto = new MemberDTO(req);
		System.out.println(dto.getMemberPasswd());
		memberService.joinMember(dto);
		return "login/member_login";
	}
}
