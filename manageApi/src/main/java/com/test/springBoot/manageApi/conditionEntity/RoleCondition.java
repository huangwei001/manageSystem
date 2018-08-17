package com.test.springBoot.manageApi.conditionEntity;

import com.test.springBoot.manageApi.entity.TRole;
import lombok.Data;

@Data
public class RoleCondition extends TRole {

    private int currentPage;

    private int pageSize;

    private int pageTotal;

    private int limit;


}
