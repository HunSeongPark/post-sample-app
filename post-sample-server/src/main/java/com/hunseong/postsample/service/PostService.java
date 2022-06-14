package com.hunseong.postsample.service;

import com.hunseong.postsample.entity.dto.PostResponse;
import com.hunseong.postsample.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Hunseong on 2022/06/14
 */
@Transactional
@RequiredArgsConstructor
@Service
public class PostService {

    private final PostRepository postRepository;

    public List<PostResponse> getPosts() {
        return postRepository.findAll()
                .stream()
                .map(PostResponse::fromEntity)
                .toList();
    }
}
