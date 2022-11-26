package com.hihisososo.realworld.repository;

import com.hihisososo.realworld.entity.Following;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class FollowingRepositoryTest {
    @Autowired
    private FollowingRepository followingRepository;

    @Test
    void testGet() {
        Optional<Following> find = followingRepository.findByUserEmailAndFollowingEmail("hihisososo1@naver.com", "test@naver.com");
        assertThat(find.isPresent()).isTrue();
    }
}