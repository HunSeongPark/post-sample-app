package com.hunseong.postsample.controller;

import com.hunseong.postsample.entity.dto.PostRequest;
import com.hunseong.postsample.entity.dto.PostResponse;
import com.hunseong.postsample.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Hunseong on 2022/06/14
 */
@RequestMapping("/posts")
@RequiredArgsConstructor
@RestController
public class PostApiController {

    private final PostService postService;

    @GetMapping
    public List<PostResponse> getPosts() {
        return postService.getPosts();
    }

    @PostMapping
    public ResponseEntity<Void> createPost(PostRequest requestDto) {
        postService.create(requestDto);
        return ResponseEntity.ok().build();
    }
}
