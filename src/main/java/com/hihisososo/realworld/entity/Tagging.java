package com.hihisososo.realworld.entity;

import javax.persistence.*;

@Entity
public class Tagging {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Article article;

    @ManyToOne
    private Tag tag;

}
