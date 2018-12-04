package com.test.springBoot.manageView.service.serviceImpl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.test.springBoot.manageApi.Utils.Page;
import com.test.springBoot.manageApi.conditionEntity.RoleCondition;
import com.test.springBoot.manageApi.entity.TResource;
import com.test.springBoot.manageApi.entity.TRole;
import com.test.springBoot.manageApi.service.RolesService;
import com.test.springBoot.manageView.service.mybaties.ResourceMapper;
import com.test.springBoot.manageView.service.mybaties.RoleMapper;
import lombok.experimental.var;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.management.relation.Role;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class RoleServiceImpl implements RolesService {

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private ResourceMapper resourceMapper;

    @Override
    public String saveRole(RoleCondition roleCondition) throws Exception {
        roleCondition.setId(UUID.randomUUID().toString());
        roleCondition.setCreatTime(new Date().getTime());
        roleMapper.saveRole(roleCondition);
        stringRedisTemplate.opsForList().leftPushAll(roleCondition.getId(), roleCondition.getResourceIds());
        return roleCondition.getId();
    }

    @Override
    public Page<TRole> getPageRoleByCondition(RoleCondition roleCondition) throws Exception {
        List<TRole> roles = roleMapper.getPageRoleByCondition(roleCondition);
        List<TRole> currentRoles = new ArrayList<>();
        for (TRole role : roles) {
            if (!StringUtils.isAllEmpty(role.getResourceIds())) {
                String[] ids = role.getResourceIds().split(",");
                List<String> resourceIds = new ArrayList<>();
                for (String id : ids) {
                    resourceIds.add(id);
                }
                List<TResource> resources = resourceMapper.getResourceNameByResourceIds(resourceIds);
                String resourceName = "";
                for (TResource resource : resources) {
                    resourceName += resource.getResourceName() + ",";
                }
                if (!StringUtils.isAllEmpty(resourceName)) {
                    resourceName = resourceName.substring(0, resourceName.length() - 1);
                }
                role.setResourceNames(resourceName);
                currentRoles.add(role);
            }
        }
        Page<TRole> rolePage = new Page<>();
        rolePage.setTotal(roleMapper.getCountByCondition(roleCondition));
        rolePage.setPageSize(roleCondition.getPageSize() > 10 ? roleCondition.getPageSize() : 10);
        rolePage.setCurrentPage(roleCondition.getCurrentPage() > 1 ? roleCondition.getCurrentPage() : 1);
        rolePage.setRows(currentRoles);
        return rolePage;
    }

    @Override
    public String updateRole(RoleCondition roleCondition) throws Exception {
        return null;
    }

    @Override
    public void deleteRole(String id) {

    }

    @Override
    public String getAllRole() throws Exception {
        List<TRole> roles = roleMapper.getAllRole();
        JSONArray result = new JSONArray();
        for (TRole role : roles) {
            JSONObject roleOne = new JSONObject();
            roleOne.put("id", role.getId());
            roleOne.put("name", role.getName());
            result.add(roleOne);
        }
        return result.toJSONString();
    }
}
