package com.hihisososo.realworld.service;

import com.hihisososo.realworld.dto.MemberLoginDTO;
import com.hihisososo.realworld.dto.MemberRegisterDTO;
import com.hihisososo.realworld.dto.MemberResponseDTO;
import com.hihisososo.realworld.dto.MemberUpdateDTO;
import com.hihisososo.realworld.entity.Member;
import com.hihisososo.realworld.security.dto.MemberUserDetailsDTO;

public interface MemberService {
    MemberResponseDTO login(MemberLoginDTO memberLoginDTO);

    MemberResponseDTO register(MemberRegisterDTO memberRegisterDTO);

    default MemberResponseDTO toResponseDTO(MemberUserDetailsDTO memberUserDetailsDTO, String accessToken) {
        MemberResponseDTO dto = new MemberResponseDTO(
                new MemberResponseDTO.Member(memberUserDetailsDTO.getEmail(),
                        accessToken,
                        memberUserDetailsDTO.getUsername(),
                        memberUserDetailsDTO.getBio(),
                        memberUserDetailsDTO.getImage()));
        return dto;
    }

    default MemberResponseDTO toResponseDTO(Member member, String accessToken) {
        MemberResponseDTO dto = new MemberResponseDTO(
                new MemberResponseDTO.Member(member.getEmail(),
                        accessToken,
                        member.getUsername(),
                        member.getBio(),
                        member.getImage()));
        return dto;
    }

    default Member toEntity(MemberRegisterDTO registerDTO) {
        return Member.builder()
                .username(registerDTO.getUsername())
                .email(registerDTO.getEmail())
                .password(registerDTO.getPassword())
                .build();
    }

    MemberResponseDTO get(String token);

    MemberResponseDTO update(String token, MemberUpdateDTO memberUpdateDTO);
}