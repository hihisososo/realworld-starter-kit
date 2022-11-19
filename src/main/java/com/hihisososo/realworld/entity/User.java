package com.hihisososo.realworld.entity;

import javax.persistence.*;

@Entity
@Table(name = "t_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long usernum;
    private String email;
    private String token;
    private String username;
    private String bio;
    private String image;
}
