package com.hihisososo.realworld.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MemberResponseDTO {
    private Member user;

    @Data
    @AllArgsConstructor
    public static class Member {
        private String email;
        private String token;
        private String username;
        private String bio;
        private String image;

    }
}
