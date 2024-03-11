package com.my.project.dto;

import java.time.LocalDate;

import com.my.project.domain.Member;

import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor // 기본생성자 자동으로 생성
public class MemberDTO {
    
	private int memberNum;
	private String memberId;
	private String memberPasswd;
	private String memberNickname;
	private String memberEmail;

	private String memberHp1;
	private String memberHp2;
	private String memberHp3;

	private String memberAdress;

	private LocalDate joinDate;

	public static MemberDTO toDTO(Member member) {
		return MemberDTO.builder()
				.memberId(member.getMemberId())
				.memberPasswd(member.getMemberPasswd())
				.memberNickname(member.getMemberNickname()).memberEmail(member.getMemberEmail())
				.memberHp1(member.getMemberHp1())
				.memberHp2(member.getMemberHp2())
				.memberHp3(member.getMemberHp3())
				.memberAdress(member.getMemberAdress())
				.joinDate(member.getJoinDate())
				.build();
	}

	public MemberDTO (HttpServletRequest req) {
		this.memberId = req.getParameter("memberId");
		this.memberPasswd = req.getParameter("memberPasswd");
		this.memberNickname = req.getParameter("memberNickname");
		this.memberEmail = req.getParameter("memberEmail");
		this.memberHp1 = req.getParameter("memberHp1");
		this.memberHp2 = req.getParameter("memberHp2");
		this.memberHp3 = req.getParameter("memberHp3");
		this.memberAdress = req.getParameter("sample6_address") + "/" + req.getParameter("sample6_detailAddress") + "/"
				+ req.getParameter("sample6_extraAddress");
	}
}
