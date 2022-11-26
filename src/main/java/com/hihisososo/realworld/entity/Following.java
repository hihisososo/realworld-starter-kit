package com.hihisososo.realworld.entity;

import javax.persistence.*;

@Entity
public class Following {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Member user;

    @ManyToOne
    private Member following;
}
