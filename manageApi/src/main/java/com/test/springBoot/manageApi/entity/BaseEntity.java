package com.test.springBoot.manageApi.entity;

import lombok.Data;

@Data
public class BaseEntity {

    private String id;

    private String creatName;

    private long creatTime;

    private String updateName;

    private long updateTime;

    private int deleteFlag;

    public BaseEntity(String id) {
        this.id = id;
    }

    public BaseEntity(){

    }


}
