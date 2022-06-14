package com.hunseong.postsample.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Created by Hunseong on 2022/06/14
 */
@Embeddable
public class Company {
    @Column(name = "company_name")
    private String name;
    private String catchPhrase;
    private String bs;
}
