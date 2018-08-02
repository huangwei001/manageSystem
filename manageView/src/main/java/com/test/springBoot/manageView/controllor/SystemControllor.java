package com.test.springBoot.manageView.controllor;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class SystemControllor {

    @RequestMapping("/")
    public String getSystemPage() {

        return "system/jumpFile";
    }

}
