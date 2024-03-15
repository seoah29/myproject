package com.my.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.my.project.domain.Member;
import com.my.project.dto.MemberDTO;
import com.my.project.repository.MemberRepository;

@Service
public class MemberService {
	
	@Autowired
	private MemberRepository memRepository;
	
	// 회원가입
	public void joinMember(MemberDTO dto) {
		Member member = dto.toDTO();
		memRepository.save(member);
	}
	
	// id 중복체크
	public boolean checkIdDuplicate(String memberId) {
        return memRepository.existsByMemberId(memberId);
    }
}