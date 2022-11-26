package com.hihisososo.realworld.service;

import com.hihisososo.realworld.dto.ProfileResponseDTO;
import com.hihisososo.realworld.entity.Member;

public interface ProfileService {
    ProfileResponseDTO get(String username);

    default ProfileResponseDTO toResponseDTO(Member member, boolean isFollowing) {
        ProfileResponseDTO dto = new ProfileResponseDTO(
                new ProfileResponseDTO.Profile(
                        member.getUsername(),
                        member.getBio(),
                        member.getImage(),
                        isFollowing
                ));
        return dto;
    }
}