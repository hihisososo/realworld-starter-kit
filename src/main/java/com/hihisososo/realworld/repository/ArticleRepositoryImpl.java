package com.hihisososo.realworld.repository;

import com.hihisososo.realworld.entity.Article;
import com.hihisososo.realworld.entity.QArticle;
import com.hihisososo.realworld.entity.QMember;
import com.querydsl.core.Tuple;
import com.querydsl.jpa.JPQLQuery;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import java.util.List;

@Log4j2
@Repository
public class ArticleRepositoryImpl extends QuerydslRepositorySupport implements ArticleRepository{

    public ArticleRepositoryImpl() {
        super(Article.class);
    }

    @Override
    public List<Tuple> listOffsetLimit(int offset, int limit) {
        QArticle article = QArticle.article;
        QMember member = QMember.member;

        JPQLQuery<Article> query = from(article);
        query.leftJoin(member).on(member.eq(article.user));
        JPQLQuery<Tuple> tuple = query
                .select(article, member)
                .orderBy(article.createdAt.desc());
        //page 처리
        tuple.offset(offset);
        tuple.limit(limit);

        List<Tuple> result = tuple.fetch();
        log.info(result);

        return result;
    }
}
