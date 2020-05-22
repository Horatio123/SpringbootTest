package com.baimahu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.Map;

@Controller
public class HelloController {

    @ResponseBody
    @RequestMapping("hello")
    public String hello() {
        return "hello";
    }

    @RequestMapping("success")
    public String success(Map<String, Object> map) {
        map.put("hello", "<h1>HELLO</h1>");
        map.put("users", Arrays.asList("Horatio", "Alexander", "Tom"));
        return "success";
    }
}
