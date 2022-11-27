package com.hihisososo.realworld.repository;

import com.hihisososo.realworld.entity.Follow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;


public interface FollowRepository extends JpaRepository<Follow, String> {
    Optional<Follow> findByFromEmailAndToEmail(@Param("fromEmail")String fromEmail, @Param("toEmail")String toEmail);
    Optional<Follow> deleteByFromEmailAndToEmail(@Param("fromEmail")String fromEmail, @Param("toEmail")String toEmail);
}
