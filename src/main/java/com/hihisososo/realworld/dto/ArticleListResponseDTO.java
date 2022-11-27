package com.hihisososo.realworld.dto;

import com.hihisososo.realworld.entity.Article;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class ArticleListResponseDTO {

    private List<Article> articles;
    private int articlesCount;

    @Builder
    public static class Article{
        private String slug;
        private String title;
        private String description;
        private String body;
        private List<String> tagList;
        private Date createdAt;
        private Date updatedAt;
        private boolean favorited;
        private int favoritesCount;
    }

    @Builder
    public static class Author{
        private String username;
        private String bio;
        private String image;
        private boolean following;
    }


}