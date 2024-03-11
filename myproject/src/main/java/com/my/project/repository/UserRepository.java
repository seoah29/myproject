package com.my.project.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.my.project.domain.Member;

@Repository
public interface UserRepository extends JpaRepository<Member, Integer> {

    Optional<Member> findByMemberId(String memberId);
}
