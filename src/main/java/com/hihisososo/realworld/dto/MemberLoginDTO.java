package com.hihisososo.realworld.dto;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class MemberLoginDTO {
    @NotNull
    @Valid
    private Member user;

    public String getEmail() {
        return this.user.email;
    }

    public String getPassword() {
        return this.user.password;
    }

    @Data
    private class Member {
        @NotEmpty
        private String email;
        @NotEmpty
        private String password;
    }
}
