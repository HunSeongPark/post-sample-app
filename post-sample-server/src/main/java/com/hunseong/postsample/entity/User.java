package com.hunseong.postsample.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Created by Hunseong on 2022/06/14
 */
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
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

    @Builder

    public User(String name, String username, String email) {
        this.name = name;
        this.username = username;
        this.email = email;
    }
}
