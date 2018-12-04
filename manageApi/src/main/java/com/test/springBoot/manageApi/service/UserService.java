package com.test.springBoot.manageApi.service;

import com.test.springBoot.manageApi.Utils.Page;
import com.test.springBoot.manageApi.conditionEntity.UserCondition;
import com.test.springBoot.manageApi.entity.TUser;



public interface UserService {

    public String saveUser(UserCondition userCondition) throws Exception;

    public void update(UserCondition userCondition) throws Exception;

    public String getUserByLoginName(String loginName) throws Exception;

    public void deleteUserById(String id) throws Exception;

    public Page<TUser> getPageUserByCondition(UserCondition userCondition) throws Exception;


}
