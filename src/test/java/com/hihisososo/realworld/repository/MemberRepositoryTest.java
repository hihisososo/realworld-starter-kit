package com.hihisososo.realworld.repository;

import com.hihisososo.realworld.entity.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.stream.IntStream;

@SpringBootTest
class MemberRepositoryTest {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Test
    void testInsert() {
        IntStream.rangeClosed(1, 100).forEach(i -> {
            Member member = Member.builder()
                    .email("hihisososo" + i + "@naver.com")
                    .password(passwordEncoder.encode("1111"))
                    .username("lyj" + i)
                    .bio("test")
                    .image("testImage").build();
            memberRepository.save(member);
        });
    }

}