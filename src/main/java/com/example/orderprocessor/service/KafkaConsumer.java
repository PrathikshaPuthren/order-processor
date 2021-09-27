package com.example.orderprocessor.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {
    private static final Logger logger = LoggerFactory.getLogger(KafkaConsumer.class);

    @Autowired
    private OrderService orderService;

    @KafkaListener(topics = "${kafka.topic}", groupId = "${kafka.consumerGroupId}")
    public void consume(String message) {
        logger.info(String.format("=> Consumed message: %s", message));
        orderService.updateOrderStatus(message,"PROCESSED");
    }

}
