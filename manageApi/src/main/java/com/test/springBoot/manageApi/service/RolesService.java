package com.test.springBoot.manageApi.service;

import com.test.springBoot.manageApi.Utils.Page;
import com.test.springBoot.manageApi.conditionEntity.RoleCondition;
import com.test.springBoot.manageApi.entity.TRole;
import org.apache.ibatis.annotations.Param;

public interface RolesService {

    public String saveRole(RoleCondition roleCondition) throws Exception;

    public Page<TRole> getPageRoleByCondition(RoleCondition roleCondition) throws Exception;

    public String updateRole(RoleCondition roleCondition) throws Exception;

    public void deleteRole(@Param("id") String id);

    public String getAllRole() throws Exception;
}
