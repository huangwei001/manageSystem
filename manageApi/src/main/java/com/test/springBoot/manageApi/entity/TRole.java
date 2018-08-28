package com.test.springBoot.manageApi.entity;

import lombok.Data;

import java.util.List;

@Data
public class TRole extends BaseEntity{

    private String name;

    private String status;

    private String resourceIds;

    private String resourceNames;
}
