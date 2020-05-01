package com.baimahu;

import com.baimahu.bean.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
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

    @Autowired
    AmqpAdmin amqpAdmin;

    @Test
    public void amqpAdminTest() {

        //amqpAdmin.declareExchange(new DirectExchange("amqpAdmin.exchange"));
        //amqpAdmin.declareQueue(new Queue("amqpAdmin.queue", true));
        amqpAdmin.declareBinding(new Binding("amqpAdmin.queue", Binding.DestinationType.QUEUE, "amqpAdmin.exchange", "amqp", null ) );
    }
    @Test
    public void send() {
        Map<String, Object> map = new HashMap<>();
        map.put("msg", "this is msg");
        map.put("data", Arrays.asList("rabbit", 123, true));
        rabbitTemplate.convertAndSend("amq.direct", "baimahu", map);

    }


    @Test
    public void receive() {
        Object o = rabbitTemplate.receiveAndConvert("baimahu");
        System.out.println(o.getClass());
        System.out.println(o);
    }


    @Test
    public void sendBook() {
        Book book = new Book("Linux", "linus", 1000);
        rabbitTemplate.convertAndSend("amq.direct", "baimahu.news", book);

    }


}
