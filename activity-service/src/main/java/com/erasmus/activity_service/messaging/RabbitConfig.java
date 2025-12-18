package com.erasmus.activity_service.messaging;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    public static final String QUEUE_NAME = "participation.joined.queue";

    @Bean
    public Queue participationJoinedQueue() {
        return new Queue(QUEUE_NAME, true);
    }
}
