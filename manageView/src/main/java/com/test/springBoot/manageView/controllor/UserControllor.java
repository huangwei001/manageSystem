package com.test.springBoot.manageView.controllor;

import com.alibaba.fastjson.JSON;
import com.test.springBoot.manageApi.Utils.Page;
import com.test.springBoot.manageApi.conditionEntity.UserCondition;
import com.test.springBoot.manageApi.entity.TUser;
import com.test.springBoot.manageApi.service.RolesService;
import com.test.springBoot.manageApi.service.UserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/user")
public class UserControllor {

    @Autowired
    private UserService userService;

    @Autowired
    private RolesService rolesService;

    @PostMapping(value = "/getUser")
    public String getUser(@RequestBody final UserCondition userCondition) throws Exception{
        userCondition.setCurrentPage(userCondition.getCurrentPage()/ userCondition.getPageSize() + 1);
        userCondition.setLimit((userCondition.getCurrentPage()-1) * userCondition.getPageSize());
        Page<TUser> userPage = userService.getPageUserByCondition(userCondition);
        return JSON.toJSONString(userPage);
    }

    @RequestMapping(value = "/getUserList", method = RequestMethod.GET)
    public String getList() throws Exception {
        return "user/userList";
    }

    @PostMapping(value = "/saveUser")
    public String saveUser(@RequestBody final UserCondition userCondition) throws Exception {
        String result = userService.saveUser(userCondition);
        if (!StringUtils.isEmpty(result)) {
            return "true";
        }
        return null;
    }

    @PostMapping(value = "/getAllRole")
    public String getAllRole() throws Exception {
        return rolesService.getAllRole();
    }
}
