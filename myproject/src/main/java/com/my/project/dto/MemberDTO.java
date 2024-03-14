package com.my.project.dto;

import java.time.LocalDate;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.my.project.domain.Member;

import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
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
				.memberNickname(member.getMemberNickname())
				.memberEmail(member.getMemberEmail())
				.memberHp1(member.getMemberHp1())
				.memberHp2(member.getMemberHp2())
				.memberHp3(member.getMemberHp3())
				.memberAdress(member.getMemberAdress())
				.joinDate(member.getJoinDate())
				.build();
	}
	
	@Builder
    public MemberDTO(String memberId, String memberPasswd, String memberNickname, String memberEmail,
    		String memberHp1, String memberHp2, String memberHp3, String memberAdress, LocalDate joinDate) {
        this.memberId = memberId;
        this.memberPasswd = memberPasswd;
        this.memberNickname = memberNickname;
        this.memberEmail = memberEmail;
        this.memberHp1 = memberHp1;
        this.memberHp2 = memberHp2;
        this.memberHp3 = memberHp3;
        this.memberAdress = memberAdress;
        this.joinDate = joinDate;
    }
	
	public Member toDTO() {
		return Member.builder()
				.memberId(memberId)
                .memberPasswd(new BCryptPasswordEncoder().encode(memberPasswd))
                .memberNickname(memberNickname)
                .memberEmail(memberEmail)
				.memberHp1(memberHp1)
				.memberHp2(memberHp2)
				.memberHp3(memberHp3)
				.memberAdress(memberAdress)
				.joinDate(joinDate)
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
