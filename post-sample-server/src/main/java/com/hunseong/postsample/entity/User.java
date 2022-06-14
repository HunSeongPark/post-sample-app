package com.hunseong.postsample.entity;

import lombok.Getter;

import javax.persistence.*;

/**
 * Created by Hunseong on 2022/06/14
 */
@Getter
@Entity
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String username;

    private String email;

    @Embedded
    private Address address;

    private String phone;

    private String website;

    @Embedded
    private Company company;
}
