package com.hihisososo.realworld.controller;

import com.hihisososo.realworld.service.ProfileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/profiles")
public class ProfileController {
    public static final String AUTHORIZATION = "Authorization";

    @Autowired
    private ProfileService profileService;

    @GetMapping("/{username}")
    public ResponseEntity get(@PathVariable String username) {
        return ResponseEntity.ok(profileService.get(username));
    }
}