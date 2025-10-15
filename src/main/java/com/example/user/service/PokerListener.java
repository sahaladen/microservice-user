package com.example.user.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class PokerListener {


    @RabbitListener(queues = "${amqp.queue.name}")
    public void receiveMessage(String message) {
        log.info("Received message from poker service: {}", message);
    }

}
