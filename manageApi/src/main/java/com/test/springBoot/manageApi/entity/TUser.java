package com.test.springBoot.manageApi.entity;

import lombok.Data;

@Data
public class TUser extends BaseEntity{

    private String name;

    private long old;

    private String email;

    private String gender ;

    private String tel;

    private String loginName;

    private String passWord;

    private Integer seq;

    public TUser(String id) {
        super(id);
    }

    public TUser(){

    }

}
