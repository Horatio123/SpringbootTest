package com.baimahu.consumer.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.baimahu.provider.service.TicketService;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Reference
    TicketService ticketService;

    public void hello() {
        String ticket = ticketService.getTicket();
        System.out.println("yes "  + ticket);
    }
}
