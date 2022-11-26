package com.hihisososo.realworld.repository;

import com.hihisososo.realworld.entity.Follow;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class followRepositoryTest {
    @Autowired
    private FollowRepository followRepository;

    @Test
    void testGet() {
        Optional<Follow> find = followRepository.findByFromEmailAndToEmail("hihisososo1@naver.com", "hihisososo10@naver.com");
        assertThat(find.isPresent()).isTrue();
    }
}