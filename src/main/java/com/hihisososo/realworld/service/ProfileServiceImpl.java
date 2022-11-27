package com.hihisososo.realworld.service;

import com.hihisososo.realworld.dto.ProfileResponseDTO;
import com.hihisososo.realworld.entity.Follow;
import com.hihisososo.realworld.entity.Member;
import com.hihisososo.realworld.repository.FollowRepository;
import com.hihisososo.realworld.repository.MemberRepository;
import com.hihisososo.realworld.security.util.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class ProfileServiceImpl implements ProfileService {

    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private FollowRepository followRepository;

    @Override
    public ProfileResponseDTO get(String token, String username) {
        Member member = memberRepository.findByUsername(username).get();
        boolean isFollow = false;
        if (Optional.ofNullable(token).isPresent()) {
            isFollow = followRepository.findByFromEmailAndToEmail(SecurityUtil.getCurrentMemberEmail(), member.getEmail()).isPresent();
        }

        return toResponseDTO(member, isFollow);
    }

    @Override
    public ProfileResponseDTO follow(String username) {
        Member member = memberRepository.findByUsername(username).get();
        String from = SecurityUtil.getCurrentMemberEmail();
        Follow follow = Follow.builder()
                .from(Member.builder().email(from).build())
                .to(member)
                .build();

        followRepository.save(follow);
        return toResponseDTO(member, true);
    }


    @Override
    @Transactional
    public ProfileResponseDTO unfollow(String username) {
        Member member = memberRepository.findByUsername(username).get();
        String from = SecurityUtil.getCurrentMemberEmail();

        followRepository.deleteByFromEmailAndToEmail(from, member.getEmail());
        return toResponseDTO(member, false);
    }

}