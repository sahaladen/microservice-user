package com.example.user.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class BlackjackListener {
    @RabbitListener(queues = "${amqp.queue.playerupdate}")
    public void receiveMessageCards(String message) {
        log.info("Received message from blackjack service: {}", message);
    }
}
