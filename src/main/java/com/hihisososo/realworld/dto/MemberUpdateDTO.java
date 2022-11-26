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

    public String getEmail() {
        return this.user.getEmail();
    }

    public String getBio() {
        return this.user.getBio();
    }

    public String getImage() {
        return this.user.image;
    }

    @Data
    private class Member {
        @NotEmpty
        private String email;
        @NotEmpty
        private String bio;
        @NotEmpty
        private String image;
    }
}
