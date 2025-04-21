package com.example.FarmerService.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String FARMER_QUEUE = "farmer.queue";

    @Bean
    public Queue farmerQueue() {
        return new Queue(FARMER_QUEUE, true); // durable = true
    }
}
