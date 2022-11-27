package com.hihisososo.realworld.controller;

import com.hihisososo.realworld.service.ProfileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestController
@RequestMapping("/api/profiles")
public class ProfileController {
    public static final String AUTHORIZATION = "Authorization";
    @Autowired
    private ProfileService profileService;

    @GetMapping("/{username}")
    public ResponseEntity get(HttpServletRequest request, @PathVariable String username) {
        return ResponseEntity.ok(profileService.get(request.getHeader(AUTHORIZATION), username));
    }

    @PostMapping("/{username}/follow")
    public ResponseEntity follow(@PathVariable String username) {
        return ResponseEntity.ok(profileService.follow(username));
    }

    @DeleteMapping("/{username}/follow")
    public ResponseEntity unfollow(@PathVariable String username) {
        return ResponseEntity.ok(profileService.unfollow(username));
    }
}