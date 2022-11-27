package com.hihisososo.realworld.service;

import com.hihisososo.realworld.constant.Constants;
import com.hihisososo.realworld.dto.ArticleListRequestDTO;
import com.hihisososo.realworld.dto.ArticleListResponseDTO;
import com.hihisososo.realworld.repository.ArticleRepository;
import com.querydsl.core.Tuple;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Log4j2
public class ArticleServiceImpl implements ArticleService{

    @Autowired
    private ArticleRepository articleRepository;

    public ArticleListResponseDTO list(String tag, String author, String favorited, Optional<Integer> limit, Optional<Integer> offset){
        List<Tuple> result = articleRepository.listOffsetLimit(offset.orElse(Constants.OFFSET), limit.orElse(Constants.LIMIT));
        log.info(result);
        return null;
    }
}
