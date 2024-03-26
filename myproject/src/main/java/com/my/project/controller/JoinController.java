package com.my.project.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.my.project.dto.MemberDTO;
import com.my.project.service.MemberService;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/member")
public class JoinController {

	private final MemberService memberService;

	@GetMapping("/join")
	public String join() {
		return "login/member_join";
	}

	@PostMapping("/join")
	public String join(HttpServletRequest req) {
		MemberDTO dto = new MemberDTO(req);
		System.out.println(dto.getMemberPasswd());
		memberService.joinMember(dto);
		return "login/member_login";
	}

	// id 중복체크
	@PostMapping("/id-verification/{memberId}")
	public ResponseEntity<?> checkMemberIdDuplicate(@PathVariable("memberId") String memberId) {
		boolean isDuplicate = memberService.checkIdDuplicate(memberId);
		return ResponseEntity.ok(isDuplicate ? "Y" : "N");
	}

	// nickname 중복체크
	@PostMapping("/nickname-verification/{memberNickname}")
	public ResponseEntity<?> checkMemberNicknameDuplicate(@PathVariable("memberNickname") String memberNickname) {
		boolean isDuplicate = memberService.checkNicknameDuplicate(memberNickname);
		return ResponseEntity.ok(isDuplicate ? "Y" : "N");
	}
}
