package com.example.user.service;

import com.example.user.PlayerDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class EventSender {
    private final AmqpTemplate amqpTemplate;
    private final String exchangeName;

    public EventSender(AmqpTemplate amqpTemplate, @Value("${amqp.exchange.name}") String exchangeName) {
        this.amqpTemplate = amqpTemplate;
        this.exchangeName = exchangeName;
    }

    public void sendPlayerInfo(PlayerDto player) {
        String routingKey = "playerinfo.new"; // must match binding pattern
        log.info("Sending player info via exchange {} with routing key {}: {}", exchangeName, routingKey, player);
        amqpTemplate.convertAndSend(exchangeName, routingKey, player);
    }

    public void sendBalanceUpdate(PlayerDto player) {
        String routingKey = "playerbalance.update"; // must match binding pattern
        log.info("Sending balance update via exchange {} with routing key {}: {}", exchangeName, routingKey, player);
        amqpTemplate.convertAndSend(exchangeName, routingKey, player);
    }
}
