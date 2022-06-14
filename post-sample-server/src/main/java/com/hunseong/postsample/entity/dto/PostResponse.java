package com.hunseong.postsample.entity.dto;

import com.hunseong.postsample.entity.Post;
import lombok.Getter;

/**
 * Created by Hunseong on 2022/06/14
 */
@Getter
public class PostResponse {
    private final Long userId;
    private final Long id;
    private final String title;
    private final String body;

    private PostResponse(Long userId, Long id, String title, String body) {
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.body = body;
    }

    public static PostResponse fromEntity(Post post) {
        return new PostResponse(post.getUser().getId(), post.getId(), post.getTitle(), post.getBody());
    }
}
