package com.hunseong.postsample;

import com.hunseong.postsample.entity.Post;
import com.hunseong.postsample.entity.User;
import com.hunseong.postsample.repository.PostRepository;
import com.hunseong.postsample.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

/**
 * Created by Hunseong on 2022/06/14
 */
@RequiredArgsConstructor
@Component
public class AppRunner implements ApplicationRunner {

    private final PostRepository postRepository;
    private final UserRepository userRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
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
    }
}
