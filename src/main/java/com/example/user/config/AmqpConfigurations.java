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
    public Queue blackjackQueue(@Value("${amqp.queue.playerupdate}") String queueName) {
        return new Queue(queueName, true); // durable queue
    }

    @Bean
    public TopicExchange blackjackExchange(
            @Value("${amqp.exchange.playerupdate}") String exchangeName) {
        return new TopicExchange(exchangeName);
    }

    @Bean
    public Binding blackjackBinding(
            Queue blackjackQueue,
            TopicExchange blackjackExchange,
            @Value("${amqp.routingkey.playerupdate}") String routingKey) {

        return BindingBuilder
                .bind(blackjackQueue)
                .to(blackjackExchange)
                .with(routingKey);
    }

    @Bean
    public Jackson2JsonMessageConverter messageConverter(){
        return new Jackson2JsonMessageConverter();
    }

}
