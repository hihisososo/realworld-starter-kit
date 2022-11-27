package com.hihisososo.realworld.controller;

import com.hihisososo.realworld.dto.ArticleListRequestDTO;
import com.hihisososo.realworld.dto.MemberLoginDTO;
import com.hihisososo.realworld.dto.MemberRegisterDTO;
import com.hihisososo.realworld.dto.MemberUpdateDTO;
import com.hihisososo.realworld.repository.ArticleRepository;
import com.hihisososo.realworld.service.ArticleService;
import com.hihisososo.realworld.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/api")
public class ArticleController {

    @Autowired
    private ArticleService articleService;


    @GetMapping("/articles")
    public ResponseEntity list(@PathVariable(required = false) String tag, @PathVariable(required = false) String author, @PathVariable(required = false) String favorited, @PathVariable(required = false) Optional<Integer> limit, @PathVariable(required = false) Optional<Integer> offset) {
        return ResponseEntity.ok(articleService.list(tag, author, favorited, limit, offset));
    }
}