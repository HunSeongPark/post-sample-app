package com.hunseong.postsample.service;

import com.hunseong.postsample.entity.Post;
import com.hunseong.postsample.entity.User;
import com.hunseong.postsample.entity.dto.PostResponse;
import com.hunseong.postsample.repository.PostRepository;
import com.hunseong.postsample.repository.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Hunseong on 2022/06/14
 */
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
}