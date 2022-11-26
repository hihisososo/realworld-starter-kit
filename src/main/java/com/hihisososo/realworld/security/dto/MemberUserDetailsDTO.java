package com.hihisososo.realworld.security.dto;

import com.hihisososo.realworld.entity.Member;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Log4j2
@Getter
@Setter
@ToString
public class MemberUserDetailsDTO extends User {
    private String email;
    private String username;
    private String bio;
    private String image;

    private MemberUserDetailsDTO(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }

    public static UserDetails from(Member member) {
        MemberUserDetailsDTO dto = new MemberUserDetailsDTO(member.getEmail(), member.getPassword(), List.of());
        dto.setEmail(member.getEmail());
        dto.setUsername(member.getUsername());
        dto.setBio(member.getBio());
        dto.setImage(member.getImage());
        return dto;
    }
}
