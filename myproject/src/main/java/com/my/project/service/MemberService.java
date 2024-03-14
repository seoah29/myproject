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
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public void joinMember(MemberDTO dto) {
		Member member = dto.toDTO();
		memRepository.save(member);
	}
}