package com.my.project.service;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.my.project.domain.Member;
import com.my.project.dto.MemberSecurityDTO;
import com.my.project.repository.MemberRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    
    @Autowired
    private MemberRepository memberRepository;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Member member = memberRepository.findByMemberId(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));

        // 권한 리스트 생성
        List<SimpleGrantedAuthority> authorities = Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"));

        // MemberSecurityDTO 객체 생성
        MemberSecurityDTO memberSecurityDTO = new MemberSecurityDTO(
            member.getMemberNum(), // 회원 번호
            member.getMemberId(), // 사용자 ID
            member.getMemberPasswd(), // 비밀번호
            member.getMemberNickname(), // 닉네임
            member.getMemberEmail(), // 이메일
            member.isSocial(), // 소셜 여부
            authorities // 권한 목록
        );

        // props가 필요한 경우, MemberSecurityDTO 인스턴스에 별도로 설정
        // 예: memberSecurityDTO.props(new HashMap<>());

        return memberSecurityDTO;
    }

}
