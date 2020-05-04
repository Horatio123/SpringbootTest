package com.baimuhu.consumer;

import com.baimahu.consumer.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
public class ConsumerApplicationTest {
    @Autowired
    UserService userService;

    @Test
    public void contextLoads() {
        userService.hello();
    }
}
