package com.test.springBoot.manageView.controllor;

import com.alibaba.fastjson.JSON;
import com.test.springBoot.manageApi.Utils.Page;
import com.test.springBoot.manageApi.conditionEntity.RoleCondition;
import com.test.springBoot.manageApi.entity.TRole;
import com.test.springBoot.manageApi.service.ResourceService;
import com.test.springBoot.manageApi.service.RolesService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "role")
public class RoleControllor {

    @Autowired
    private RolesService rolesService;

    @Autowired
    private ResourceService resourceService;


    @PostMapping(value = "/getRolePage")
    public String getRolePage(@RequestBody  final RoleCondition roleCondition) throws Exception {
        roleCondition.setCurrentPage(roleCondition.getCurrentPage() / roleCondition.getPageSize() + 1);
        roleCondition.setLimit((roleCondition.getCurrentPage()-1) * roleCondition.getPageSize());
        Page<TRole> rolePage = rolesService.getPageRoleByCondition(roleCondition);
        return JSON.toJSONString(rolePage);
    }

    @PostMapping(value = "/saveRole")
    public String saveRole(@RequestBody final RoleCondition roleCondition) throws Exception {
        String result = rolesService.saveRole(roleCondition);
        if (!StringUtils.isAllEmpty(result)) {
            return "true";
        }
        return null;
    }

    @PostMapping(value = "/getResourceTree")
    public String getResourceTree() throws Exception {
        String result = resourceService.getResourceTree();
        return result;
    }



}
