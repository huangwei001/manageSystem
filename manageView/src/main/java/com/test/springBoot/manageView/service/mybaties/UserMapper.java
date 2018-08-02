package com.test.springBoot.manageView.service.mybaties;

import com.test.springBoot.manageApi.conditionEntity.UserCondition;
import com.test.springBoot.manageApi.entity.TUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {

    public void saveUser(UserCondition userCondition) throws Exception;

    public void update(UserCondition userCondition) throws Exception;

    public TUser getUserByLoginName(String loginName) throws Exception;

    public Integer deleteUserById(@Param("id") String id) throws Exception;

    public List<TUser> getUserListByCondition(UserCondition userCondition) throws Exception;

    public Integer getCount(UserCondition userCondition) throws Exception;

    public Integer getMaxSeq() throws Exception;
}
