package com.baimahu;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootAmqpApplicationTests {
    @Autowired
    RabbitTemplate rabbitTemplate;

    @Test
    public void receive() {
        Object o = rabbitTemplate.receiveAndConvert("baimahu");
        System.out.println(o.getClass());
        System.out.println(o);
    }


    @Test
    public void contextLoads() {
        Map<String, Object> map = new HashMap<>();
        map.put("msg", "this is msg");
        map.put("data", Arrays.asList("rabbit", 123, true));

        rabbitTemplate.convertAndSend("amq.direct", "baimahu", map);

    }

}
