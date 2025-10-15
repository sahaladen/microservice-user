package com.example.user.config;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class AmqpConfigurations {
    @Bean
    public Queue pokerQueue(@Value("${amqp.queue.name}") String queueName) {
        return new Queue(queueName, true); // durable queue
    }
}
