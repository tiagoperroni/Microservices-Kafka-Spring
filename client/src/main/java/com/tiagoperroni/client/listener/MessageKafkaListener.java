package com.tiagoperroni.client.listener;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tiagoperroni.client.model.OrderResponse;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class MessageKafkaListener {

    public static OrderResponse orderResponse;   

    @KafkaListener(topics = "${topic.order-cliente}", groupId = "group_id2")
    public void getOrder(String orderString) throws JsonMappingException, JsonProcessingException {  
       
        log.info("New order received: {}", orderString);

        ObjectMapper mapper = new ObjectMapper();
        OrderResponse order = mapper.readValue(orderString, OrderResponse.class);

        if (order.getStock().equals("out")) {
            var newOrderResponse = new OrderResponse();
            orderResponse = newOrderResponse.create(order);
            
        }
        
        log.info("A new order was received: {}", order);
        var newOrderResponse = new OrderResponse();
        orderResponse = newOrderResponse.create(order);

    }
    
}
