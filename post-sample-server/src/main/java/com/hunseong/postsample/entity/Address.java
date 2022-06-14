package com.hunseong.postsample.entity;

import lombok.AllArgsConstructor;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;

/**
 * Created by Hunseong on 2022/06/14
 */
@Embeddable
public class Address {

    private String street;
    private String city;
    private String zipcode;

    @Embedded
    private Geo geo;
}
