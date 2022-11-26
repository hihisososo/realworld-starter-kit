package com.hihisososo.realworld.service;

import com.hihisososo.realworld.dto.*;
import com.hihisososo.realworld.entity.Member;
import com.hihisososo.realworld.exception.DuplicateMemberException;
import com.hihisososo.realworld.repository.MemberRepository;
import com.hihisososo.realworld.security.dto.MemberUserDetailsDTO;
import com.hihisososo.realworld.security.jwt.JwtTokenProvider;
import com.hihisososo.realworld.security.util.SecurityUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final JwtTokenProvider jwtTokenProvider;
    private final PasswordEncoder passwordEncoder;

    private static final Set<String> updateAcceptField = Set.of("email", "username", "password", "image", "bio");

    @Transactional
    public MemberResponseDTO login(MemberLoginDTO memberLoginDTO) {
        // 1. Login ID/PW 를 기반으로 Authentication 객체 생성
        // 이때 authentication 는 인증 여부를 확인하는 authenticated 값이 false
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(memberLoginDTO.getEmail(), memberLoginDTO.getPassword());

        // 2. 실제 검증 (사용자 비밀번호 체크)이 이루어지는 부분
        // authenticate 매서드가 실행될 때 CustomUserDetailsService 에서 만든 loadUserByUsername 메서드가 실행
        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);

        MemberUserDetailsDTO memberUserDetailsDTO = (MemberUserDetailsDTO) authentication.getPrincipal();

        // 3. 인증 정보를 기반으로 JWT 토큰 생성
        TokenInfo tokenInfo = jwtTokenProvider.generateToken(memberUserDetailsDTO.getEmail());

        return toResponseDTO(memberUserDetailsDTO, tokenInfo.getAccessToken());
    }

    public MemberResponseDTO register(MemberRegisterDTO memberRegisterDTO) {
        memberRepository.findByEmail(memberRegisterDTO.getEmail()).ifPresent(m -> {
            throw new DuplicateMemberException();
        });

        memberRegisterDTO.setPassword(passwordEncoder.encode(memberRegisterDTO.getPassword()));
        Member member = toEntity(memberRegisterDTO);
        memberRepository.save(member);
        TokenInfo tokenInfo = jwtTokenProvider.generateToken(member.getEmail());
        return toResponseDTO(member, tokenInfo.getAccessToken());
    }

    @Override
    public MemberResponseDTO get(String token) {
        return toResponseDTO(memberRepository.findByUsername(SecurityUtil.getCurrentMemberUsername()).get(), token);
    }

    @Override
    public MemberResponseDTO update(String token, MemberUpdateDTO memberUpdateDTO) {

        Member member = memberRepository.findByEmail(memberUpdateDTO.getEmail()).get();
        member.update(memberUpdateDTO.getEmail(), memberUpdateDTO.getBio(), memberUpdateDTO.getImage());
        memberRepository.save(member);
        return toResponseDTO(member, token);
    }


}