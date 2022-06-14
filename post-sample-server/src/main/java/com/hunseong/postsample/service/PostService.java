package com.hunseong.postsample.service;

import com.hunseong.postsample.entity.User;
import com.hunseong.postsample.entity.dto.PostRequest;
import com.hunseong.postsample.entity.dto.PostResponse;
import com.hunseong.postsample.repository.PostRepository;
import com.hunseong.postsample.repository.UserRepository;
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
    private final UserRepository userRepository;

    public List<PostResponse> getPosts() {
        return postRepository.findAll()
                .stream()
                .map(PostResponse::fromEntity)
                .toList();
    }

    public void create(PostRequest requestDto) {
        User user = userRepository.findById(requestDto.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("user not found"));
        postRepository.save(requestDto.toEntity(user));
    }
}
