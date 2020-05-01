package com.baimahu.service;

import com.baimahu.bean.Book;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    @RabbitListener(queues = "baimahu")
//    public void receive(Message message) {
//        System.out.println(message.getBody());
//        System.out.println(message.getMessageProperties());
//    }
    public void receive(Book book) {
        System.out.println("received book: " + book);
    }
}
