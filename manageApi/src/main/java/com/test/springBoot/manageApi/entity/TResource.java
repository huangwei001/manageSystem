package com.test.springBoot.manageApi.entity;

import lombok.Data;

@Data
public class TResource extends BaseEntity{
    //资源名称
    private String resourceName;
    //上级资源Id
    private String parentRsourceId;
    //上级资源名称(冗余)
    private String parentResourceName;
    // 资源编码
    private String resourceCode;
    //资源路径
    private String resourceUrl;
    //资源类型
    private String resourceType;
    //启用状态
    private String isAvailable;

}
