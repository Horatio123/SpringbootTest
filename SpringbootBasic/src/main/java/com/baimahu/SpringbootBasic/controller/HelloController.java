package com.baimahu.SpringbootBasic.controller;

import com.baimahu.SpringbootBasic.bean.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Map;

//@ResponseBody
//@RestController
@Controller
public class HelloController {

    @Autowired
    Person me;

    @Value("${country}")
    private String country;

    @ResponseBody
    @RequestMapping("/hello")
    public String hello() {
        return "hello spring boot in " + country;
    }

    @RequestMapping("/success")
    public String success(Map<String, Object> map) {
        map.put("hello", "<h2>are you ok</h2>");
        map.put("students", Arrays.asList("Tom", "Jerry", "Spike"));
        return "success";
    }

    @ResponseBody
    @RequestMapping("/me")
    public String me() {
        return me.toString();
    }
}
