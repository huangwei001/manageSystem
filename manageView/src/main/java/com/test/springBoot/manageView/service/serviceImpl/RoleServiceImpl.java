package com.test.springBoot.manageView.service.serviceImpl;

import com.test.springBoot.manageApi.Utils.Page;
import com.test.springBoot.manageApi.conditionEntity.RoleCondition;
import com.test.springBoot.manageApi.entity.TRole;
import com.test.springBoot.manageApi.service.RolesService;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RolesService {


    @Override
    public String saveRole(RoleCondition roleCondition) throws Exception {
        return null;
    }

    @Override
    public Page<TRole> getPageRoleByCondition(RoleCondition roleCondition) throws Exception {
        return null;
    }

    @Override
    public String updateRole(RoleCondition roleCondition) throws Exception {
        return null;
    }

    @Override
    public void deleteRole(String id) {

    }
}
