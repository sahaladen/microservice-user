package com.example.user.config;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class AmqpConfigurations {
    @Value("${amqp.exchange.name}")
    private String exchangeName;

    @Value("${amqp.queue.name}")
    private String playerInfoQueueName;
    @Bean
    public Queue pokerQueue(@Value("${amqp.queue.name}") String queueName) {
        return new Queue(queueName, true); // durable queue
    }

    @Bean
    public Jackson2JsonMessageConverter messageConverter(){
        return new Jackson2JsonMessageConverter();
    }

}
