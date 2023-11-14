package com.events.userevents.messaging;

import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class UserEventListener {
    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange("userManagementExchange");
    }

    @RabbitListener(queues = "${rabbitmq.queue}")
    public void receiveMessage(String message) {
        System.out.println(message);
        // Logic to save the event in the database would invoke a service call here to do this but it's not necessary for this demo
    }
}
