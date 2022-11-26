package com.hihisososo.realworld.entity;

import com.hihisososo.realworld.dto.MemberUpdateDTO;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Optional;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Member {

    @Id
    private String email;
    private String username;
    private String password;
    private String bio;
    private String image;

    public void change(MemberUpdateDTO memberUpdateDTO) {
        Optional<String> username= Optional.ofNullable(memberUpdateDTO.getUsername());
        Optional<String> password= Optional.ofNullable(memberUpdateDTO.getPassword());
        Optional<String> image= Optional.ofNullable(memberUpdateDTO.getImage());
        Optional<String> bio= Optional.ofNullable(memberUpdateDTO.getBio());

        username.ifPresent(s -> this.setUsername(s));
        password.ifPresent(s -> this.setPassword(s));
        image.ifPresent(s -> this.setImage(s));
        bio.ifPresent(s -> this.setBio(s));
    }
}
