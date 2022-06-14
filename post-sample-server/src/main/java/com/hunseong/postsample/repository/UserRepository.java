package com.hunseong.postsample.repository;

import com.hunseong.postsample.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Hunseong on 2022/06/14
 */
public interface UserRepository extends JpaRepository<User, Long> {
}
