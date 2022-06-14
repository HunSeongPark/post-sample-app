package com.hunseong.postsample.controller;

import com.hunseong.postsample.entity.dto.PostResponse;
import com.hunseong.postsample.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
