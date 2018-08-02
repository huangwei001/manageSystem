package com.test.springBoot.manageView.service.serviceImpl;

import com.test.springBoot.manageApi.Utils.Page;
import com.test.springBoot.manageApi.conditionEntity.UserCondition;
import com.test.springBoot.manageApi.entity.TUser;
import com.test.springBoot.manageApi.service.UserService;
import com.test.springBoot.manageView.service.mybaties.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;


    @Override
    public String saveUser(UserCondition userCondition) throws Exception {
        Integer seq = userMapper.getMaxSeq();
        if (seq == null) {
            seq = 0;
        }
        userCondition.setId(UUID.randomUUID().toString());
        userCondition.setSeq(++seq);
        userMapper.saveUser(userCondition);
        return userCondition.getId();
    }

    @Override
    public void update(UserCondition userCondition) throws Exception {

    }

    @Override
    public String getUserByLoginName(String loginName) throws Exception {
        return null;
    }

    @Override
    public void deleteUserById(String id) throws Exception {

    }

    @Override
    public Page<TUser> getPageUserByCondition(UserCondition userCondition) throws Exception {
        List<TUser> userList = userMapper.getUserListByCondition(userCondition);
        Integer total = userMapper.getCount(userCondition);
        Page<TUser> userPage = new Page<>();
        userPage.setRows(userList);
        userPage.setCurrentPage(userCondition.getCurrentPage() > 0 ? userCondition.getCurrentPage() : 1);
        userPage.setPageSize(userCondition.getPageSize() > 10 ? userCondition.getPageSize() : 10);
        userPage.setTotal(total);
        return userPage;
    }
}
