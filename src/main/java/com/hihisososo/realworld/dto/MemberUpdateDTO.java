package com.hihisososo.realworld.dto;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class MemberUpdateDTO {
    @NotNull
    @Valid
    private Member user;

    public Member getMember() {
        return user;
    }

    public String getUsername() {
        return user.username;
    }

    public String getPassword() {
        return user.password;
    }

    public String getImage() {
        return user.image;
    }

    public String getBio() {
        return user.bio;
    }

    public String getEmail() {
        return user.email;
    }

    @Data
    private class Member {
        @NotEmpty
        private String email;
        private String username;
        private String password;
        private String image;
        private String bio;
    }
}
