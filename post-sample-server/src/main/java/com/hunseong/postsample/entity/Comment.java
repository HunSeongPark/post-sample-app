package com.hunseong.postsample.entity;

import lombok.Getter;

import javax.persistence.*;

/**
 * Created by Hunseong on 2022/06/14
 */
@Getter
@Entity
public class Comment {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;

    private String name;

    private String email;

    private String body;
}
