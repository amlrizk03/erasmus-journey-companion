package com.erasmus.participationservice.messaging;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    public static final String QUEUE_NAME = "participation.joined.queue";

    @Bean
    public Queue participationQueue() {
        return new Queue(QUEUE_NAME, true);
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory factory) {
        return new RabbitTemplate(factory);
    }
}
