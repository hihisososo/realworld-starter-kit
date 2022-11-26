package com.hihisososo.realworld.repository;

import com.hihisososo.realworld.entity.Following;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;


public interface FollowingRepository extends JpaRepository<Following, String> {
    Optional<Following> findByFollowingUsernameAndUserUsername(@Param("followingUsername") String followingUsername, @Param("userUsername") String userUsername);

}
