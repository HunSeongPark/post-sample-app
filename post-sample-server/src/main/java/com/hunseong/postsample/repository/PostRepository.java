package com.hunseong.postsample.repository;

import com.hunseong.postsample.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Hunseong on 2022/06/14
 */
public interface PostRepository extends JpaRepository<Post, Long> {
}
