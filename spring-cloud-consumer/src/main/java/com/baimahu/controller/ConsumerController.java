package com.baimahu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerController {
    @Autowired
    RestTemplate restTemplate;
    @GetMapping("/buy")
    public String butTicket(String name) {
        String s = restTemplate.getForObject("http://PROVIDER/ticket", String.class);
        return name + " buy " + s;
    }
}
