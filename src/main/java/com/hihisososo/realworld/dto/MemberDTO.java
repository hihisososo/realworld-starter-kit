package com.hihisososo.realworld.dto;

import lombok.Data;

@Data
public class MemberDTO {
    private String email;
    private String password;
    private String username;
    private String bio;
    private String image;
}
