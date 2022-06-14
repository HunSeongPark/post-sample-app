package com.hunseong.postsample.entity;

import javax.persistence.Embeddable;

/**
 * Created by Hunseong on 2022/06/14
 */
@Embeddable
public class Geo {
    private String lat;
    private String lng;
}
