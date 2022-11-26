package com.hihisososo.realworld.security.util;

import com.hihisososo.realworld.security.dto.MemberUserDetailsDTO;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class SecurityUtil {
    public static String getCurrentMemberId() {
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || authentication.getName() == null) {
            throw new RuntimeException("No authentication information.");
        }
        MemberUserDetailsDTO detailsDTO = (MemberUserDetailsDTO) authentication.getPrincipal();
        return detailsDTO.getEmail();
    }
}