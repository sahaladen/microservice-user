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

    @Value("${amqp.queue.balance}")
    private String balanceQueueName;
    @Bean
    public Queue pokerQueue(@Value("${amqp.queue.name}") String queueName) {
        return new Queue(queueName, true); // durable queue
    }

    @Bean
    public Queue playerInfoQueue() {
        return new Queue(playerInfoQueueName, true);
    }

    @Bean
    public Queue balanceQueue() {
        return new Queue(balanceQueueName, true);
    }

    @Bean
    public TopicExchange playerExchange() {
        return new TopicExchange(exchangeName);
    }

    @Bean
    public Binding playerInfoBinding(Queue playerInfoQueue, TopicExchange playerExchange) {
        return BindingBuilder.bind(playerInfoQueue).to(playerExchange).with("playerinfo.*");
    }

    @Bean
    public Binding balanceBinding(Queue balanceQueue, TopicExchange playerExchange) {
        return BindingBuilder.bind(balanceQueue).to(playerExchange).with("playerbalance.*");
    }
    @Bean
    public Jackson2JsonMessageConverter messageConverter(){
        return new Jackson2JsonMessageConverter();
    }

}
