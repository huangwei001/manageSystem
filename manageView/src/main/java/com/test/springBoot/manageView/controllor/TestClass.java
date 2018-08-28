package com.test.springBoot.manageView.controllor;

import com.google.common.collect.Maps;

import java.util.Map;

public class TestClass {


    public static void main(String[] args) {
        Map<String, Object> ha = Maps.newHashMap();
        ha.put("status", true);
        ha.put("status1", false);
        ha.put("status2", null);

        System.out.println((boolean) ha.get("status"));
        System.out.println((boolean) ha.get("status1"));
        System.err.println(Boolean.parseBoolean((String) ha.get("status2")));
    }
}
