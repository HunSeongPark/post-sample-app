package com.hunseong.postsample.service;

import com.hunseong.postsample.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Created by Hunseong on 2022/06/14
 */
@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
}
