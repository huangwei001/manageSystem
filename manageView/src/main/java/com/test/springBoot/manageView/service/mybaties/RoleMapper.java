package com.test.springBoot.manageView.service.mybaties;

import com.test.springBoot.manageApi.Utils.Page;
import com.test.springBoot.manageApi.conditionEntity.RoleCondition;
import com.test.springBoot.manageApi.entity.TRole;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleMapper {

    public void saveRole(RoleCondition roleCondition) throws Exception;

    public List<TRole> getPageRoleByCondition(RoleCondition roleCondition) throws Exception;

    public String updateRole(RoleCondition roleCondition) throws Exception;

    public void deleteRole(@Param("id") String id);

    public Integer getCountByCondition(RoleCondition roleCondition) throws Exception;

    public List<TRole> getAllRole() throws Exception;


}
