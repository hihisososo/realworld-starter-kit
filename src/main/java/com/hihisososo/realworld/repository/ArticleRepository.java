package com.hihisososo.realworld.repository;

import com.querydsl.core.Tuple;

import java.util.List;


public interface ArticleRepository {
    List<Tuple> listOffsetLimit(int offset, int limit);
}
