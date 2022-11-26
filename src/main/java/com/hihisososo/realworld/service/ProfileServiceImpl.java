package com.hihisososo.realworld.service;

import com.hihisososo.realworld.dto.ProfileResponseDTO;
import com.hihisososo.realworld.entity.Member;
import com.hihisososo.realworld.repository.FollowingRepository;
import com.hihisososo.realworld.repository.MemberRepository;
import com.hihisososo.realworld.security.util.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileServiceImpl implements ProfileService {

    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private FollowingRepository followingRepository;

    @Override
    public ProfileResponseDTO get(String username) {
        Member member = memberRepository.findByUsername(username).get();
        boolean isFollow = false;
        if (SecurityUtil.isAuthenticated()) {
            isFollow = followingRepository.findByFollowingUsernameAndUserUsername(member.getEmail(), SecurityUtil.getCurrentMemberUsername()).isPresent();
        }

        return toResponseDTO(member, isFollow);
    }

}