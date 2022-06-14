package com.hunseong.postsample.entity.dto;

import com.hunseong.postsample.entity.Post;
import com.hunseong.postsample.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Created by Hunseong on 2022/06/14
 */
@Getter
@AllArgsConstructor
public class PostRequest {
    Long userId;
    String title;
    String body;

    public Post toEntity(User user) {
        return new Post(user, title, body);
    }
}
