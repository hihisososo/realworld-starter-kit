package com.hihisososo.realworld.repository;

import com.hihisososo.realworld.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;


public interface MemberRepository extends JpaRepository<Member, String> {
    Optional<Member> findByEmail(@Param("email") String email);

    Optional<Member> findByUsername(@Param("username") String username);

}
