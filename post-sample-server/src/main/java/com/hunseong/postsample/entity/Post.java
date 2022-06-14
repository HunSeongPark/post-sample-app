package com.hunseong.postsample.entity;

import lombok.Getter;

import javax.persistence.*;

/**
 * Created by Hunseong on 2022/06/14
 */
@Getter
@Entity
public class Post {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    private String title;

    private String body;
}
