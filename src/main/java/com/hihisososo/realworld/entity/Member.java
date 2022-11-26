package com.hihisososo.realworld.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Member {
    @Id
    private String email;
    private String password;
    private String username;
    private String bio;
    private String image;

    public void update(String email, String bio, String image) {
        this.email = email;
        this.bio = bio;
        this.image = image;
    }
}
