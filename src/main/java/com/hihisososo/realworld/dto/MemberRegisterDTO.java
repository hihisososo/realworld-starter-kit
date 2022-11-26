package com.hihisososo.realworld.dto;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class MemberRegisterDTO {
    @NotNull
    @Valid
    private Member user;

    public String getEmail() {
        return this.user.email;
    }

    public String getUsername() {
        return this.user.username;
    }

    public String getPassword() {
        return this.user.password;
    }

    public void setPassword(String password) {
        this.user.password = password;
    }

    @Data
    private class Member {
        @NotEmpty
        private String email;
        @NotEmpty
        private String username;
        @NotEmpty
        private String password;
    }

}
