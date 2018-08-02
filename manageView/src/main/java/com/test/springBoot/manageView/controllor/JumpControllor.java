package com.test.springBoot.manageView.controllor;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping(value = "jump")
@Controller
public class JumpControllor {

    @RequestMapping(value = "/getUserList", method = RequestMethod.GET)
    public String getList() throws Exception {
        return "user/userList";
    }



}
