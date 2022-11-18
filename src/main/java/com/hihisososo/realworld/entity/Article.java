package com.hihisososo.realworld.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Article extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String slug;
    private String title;
    private String description;
    private String body;
    private boolean favorited;
    private int favoritesCount;

    @ManyToOne
    private User user;

}
