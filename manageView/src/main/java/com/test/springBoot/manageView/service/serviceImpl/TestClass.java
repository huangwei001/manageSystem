package com.test.springBoot.manageView.service.serviceImpl;

import com.google.common.collect.Maps;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;
import java.util.EnumSet;
import java.util.Collections;
public class TestClass {

    public static void main(String[] args) {
        String id = "2";
        List<Integer> all = new ArrayList<>();
        for (String ids : id.split(",")) {
            all.add(Integer.valueOf(ids));
        }
        System.out.println(all);
        System.err.println(generateValue(id));
    }


    private static int generateValue(String s) {
        int fRes = 0;
        if (!s.equals("0")) {
            int m = Integer.valueOf(s) - 1;
            fRes |= (1 << m);
        }
        return fRes;
    }


    public void test() {
        FileSystemXmlApplicationContext applicationContext = new FileSystemXmlApplicationContext("application.per");
        Maps.newConcurrentMap();
    }

}
