package com.example.demo.producer;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQSender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    @Value("${javainuse.rabbitmq.exchange:exchange1}")
    private String exchange;

    @Value("${javainuse.rabbitmq.routingkey:queue1}")
    private String routingkey;

    public void send(String value) {
        rabbitTemplate.convertAndSend(exchange, routingkey, value);
        System.out.println("Send msg = " + value);

    }
}
