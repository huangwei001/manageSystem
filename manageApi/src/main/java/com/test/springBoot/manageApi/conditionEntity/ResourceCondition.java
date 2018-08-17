package com.test.springBoot.manageApi.conditionEntity;

import com.test.springBoot.manageApi.entity.TResource;
import lombok.Data;

@Data
public class ResourceCondition extends TResource {
    private int currentPage;

    private int pageSize;

    private int pageTotal;

    private int limit;


}
