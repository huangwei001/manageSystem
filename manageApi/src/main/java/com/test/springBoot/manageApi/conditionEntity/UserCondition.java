package com.test.springBoot.manageApi.conditionEntity;

import com.test.springBoot.manageApi.entity.TUser;
import lombok.Data;


@Data
public class UserCondition extends TUser {

    private int currentPage;

    private int pageSize;

    private int pageTotal;

    private int limit;

}
