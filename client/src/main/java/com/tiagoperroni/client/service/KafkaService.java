package com.tiagoperroni.client.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class KafkaService {

    @Value("${topic.shop-cliente}")
    private String topicShopClient;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String message) {
        this.kafkaTemplate.send(topicShopClient, message);
        log.info("Mensagem enviada para o topic_endereco_cliente: {}", message);
    }

}
