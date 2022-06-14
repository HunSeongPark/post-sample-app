package com.hunseong.postsample.service;

import com.hunseong.postsample.entity.Post;
import com.hunseong.postsample.entity.User;
import com.hunseong.postsample.entity.dto.PostRequest;
import com.hunseong.postsample.entity.dto.PostResponse;
import com.hunseong.postsample.repository.PostRepository;
import com.hunseong.postsample.repository.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Hunseong on 2022/06/14
 */
@Transactional
@SpringBootTest
class PostServiceTest {

    @Autowired
    private PostService postService;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    @DisplayName("post 목록을 가져온다")
    @Test
    void findAll() {

        // given
        User user = User.builder()
                .name("hunseong")
                .username("hunseong")
                .email("gnstj@gnstjd.com")
                .build();

        userRepository.save(user);

        Post post1 = Post.builder()
                .user(user)
                .title("title1")
                .body("body1")
                .build();

        Post post2 = Post.builder()
                .user(user)
                .title("title2")
                .body("body2")
                .build();

        Post post3 = Post.builder()
                .user(user)
                .title("title3")
                .body("body3")
                .build();

        Post savedPost1 = postRepository.save(post1);
        Post savedPost2 = postRepository.save(post2);
        Post savedPost3 = postRepository.save(post3);

        // when
        List<PostResponse> result = postService.getPosts();

        // then
        assertThat(result.size()).isEqualTo(3);
        assertThat(result.get(0).getTitle()).isEqualTo(savedPost1.getTitle());
        assertThat(result.get(1).getTitle()).isEqualTo(savedPost2.getTitle());
        assertThat(result.get(2).getTitle()).isEqualTo(savedPost3.getTitle());
    }

    @DisplayName("post를 생성한다")
    @Test
    void create() {

        // given
        User user = User.builder()
                .name("hunseong")
                .username("hunseong")
                .email("gnstj@gnstjd.com")
                .build();

        User savedUser = userRepository.save(user);

        PostRequest request = new PostRequest(savedUser.getId(), "title", "body");

        // when
        postService.create(request);

        // then
        List<PostResponse> result = postService.getPosts();
        assertThat(result.size()).isEqualTo(1);
        assertThat(result.get(0).getTitle()).isEqualTo("title");
        assertThat(result.get(0).getBody()).isEqualTo("body");
    }
}