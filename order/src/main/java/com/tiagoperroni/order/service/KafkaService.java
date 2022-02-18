package com.tiagoperroni.order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class KafkaService {

    @Value("${topic.order-cliente}")
    private String topicOrderClient;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String message) {
        this.kafkaTemplate.send(topicOrderClient, message);
        log.info("Mensagem enviada para o topic_compra_cliente: {}", message);
    }
    
}
