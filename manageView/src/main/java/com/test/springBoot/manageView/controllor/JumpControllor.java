package com.test.springBoot.manageView.controllor;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping(value = "jump")
@Controller
public class JumpControllor {

    //用户页面跳转
    @RequestMapping(value = "/jumpFile", method = RequestMethod.GET)
    public String getList() throws Exception {
        return "system/jumpFile";
    }
    //用户页面跳转
    @RequestMapping(value = "/getUserList", method = RequestMethod.GET)
    public String getUserList() throws Exception {
        return "user/userList";
    }
    //资源页面跳转
    @RequestMapping(value = "getResourceList", method = RequestMethod.GET)
    public String getResourceList() throws Exception {
        return "resource/resourceList";
    }

    @RequestMapping(value = "getRoleList", method = RequestMethod.GET)
    public String getRoleList() throws Exception {

        return "role/roleList";

    }

}
