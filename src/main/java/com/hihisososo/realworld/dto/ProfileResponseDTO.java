package com.hihisososo.realworld.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class ProfileResponseDTO {
    public Profile profile;

    @AllArgsConstructor
    public static class Profile{
        public String username;
        public String bio;
        public String image;
        public boolean following;
    }
}
