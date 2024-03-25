package com.my.project.service;

import java.util.Optional;

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
	
	@Autowired
	private PasswordEncoder passwordEncoder; // PasswordEncoder 주입
	
	// 회원가입
	public void joinMember(MemberDTO dto) {
		Member member = dto.toDTO();
		memRepository.save(member);
	}
	
	// id 중복체크
	public boolean checkIdDuplicate(String memberId) {
        return memRepository.existsByMemberId(memberId);
    }
	
	// Member 정보 가져오기
    public MemberDTO getMember(String memberId) {
        Optional<Member> memberOptional = memRepository.findByMemberId(memberId);
        if (memberOptional.isPresent()) {
            Member member = memberOptional.get();
            return convertEntityToDto(member);
        }
        return null;
    }

	private MemberDTO convertEntityToDto(Member member) {
		return null;
	}
}