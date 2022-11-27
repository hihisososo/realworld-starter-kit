package com.hihisososo.realworld.service;

import com.hihisososo.realworld.dto.ArticleListResponseDTO;

import java.util.Optional;

public interface ArticleService {
    ArticleListResponseDTO list(String tag, String author, String favorited, Optional<Integer> limit, Optional<Integer> offset);
}
