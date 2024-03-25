package com.my.project.domain;

import java.time.LocalDate;

import com.my.project.dto.MemberDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Member {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
    
    private LocalDate memberDeletedate;
    
    private boolean isSocial;
    
    public Member(MemberDTO dto) {
    	
    	this.memberNum = dto.getMemberNum();
    	this.memberId = dto.getMemberId();
    	this.memberPasswd = dto.getMemberPasswd();
    	this.memberNickname = dto.getMemberNickname();
    	this.memberEmail = dto.getMemberEmail();
    	this.memberHp1 = dto.getMemberHp1();
    	this.memberHp2 = dto.getMemberHp2();
    	this.memberHp3 = dto.getMemberHp3();
    	this.memberAdress = dto.getMemberAdress();
    }
    
    @Builder
    public Member(String memberId, String memberPasswd, String memberNickname, String memberEmail, 
    		String memberHp1, String memberHp2, String memberHp3, String memberAdress, LocalDate joinDate, LocalDate memberDeletedate) {
        this.memberId = memberId;
        this.memberPasswd = memberPasswd;
        this.memberNickname = memberNickname;
        this.memberEmail = memberEmail;
        this.memberHp1 = memberHp1;
        this.memberHp2 = memberHp2;
        this.memberHp3 = memberHp3;
        this.memberAdress = memberAdress;
        this.joinDate = joinDate;
        this.memberDeletedate = memberDeletedate;
    }
}
