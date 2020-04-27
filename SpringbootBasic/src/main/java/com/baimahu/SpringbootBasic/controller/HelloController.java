package com.baimahu.SpringbootBasic.controller;

import com.baimahu.SpringbootBasic.bean.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*@ResponseBody
@Controller*/
@RestController
public class HelloController {

    @Autowired
    Person me;

    @Value("${country}")
    private String country;


    @RequestMapping("/hello")
    public String hello() {
        return "hello spring boot in " + country;
    }

    @RequestMapping("/me")
    public Person me() {
        return me;
    }
}
