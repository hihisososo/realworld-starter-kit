package com.hihisososo.realworld.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@AllArgsConstructor
@Data
public class ArticleListRequestDTO {

    private int limit;
    private int offset;
    private String tag;
    private String author;
    private String favorited;

}