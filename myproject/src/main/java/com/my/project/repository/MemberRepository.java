package com.my.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.my.project.domain.Member;
import com.my.project.dto.MemberDTO;

@Repository
public interface MemberRepository extends JpaRepository<Member, Integer> {

	// 회원가입
	void save(MemberDTO dto);
	
	// id 중복체크
	boolean existsByMemberId(String memberId);

}
