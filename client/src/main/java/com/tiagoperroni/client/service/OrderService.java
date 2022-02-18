package com.tiagoperroni.client.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tiagoperroni.client.dto.OrderResponseDTO;
import com.tiagoperroni.client.exception.ProductOutOfStockException;
import com.tiagoperroni.client.listener.MessageKafkaListener;
import com.tiagoperroni.client.mapper.OrderMapper;
import com.tiagoperroni.client.model.Order;
import com.tiagoperroni.client.model.OrderResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class OrderService {

    @Autowired
    private KafkaService kafkaService;

    public OrderResponseDTO save(Order order) throws JsonProcessingException {

        log.info("## Data sending by client: {}", order);      

        ObjectMapper mapper = new ObjectMapper();
        String message = mapper.writeValueAsString(order);

        this.kafkaService.sendMessage(message);
        log.info("## Data sending to Kafka: {}", order);

        OrderResponse orderResponse = null;
        try {            
            Thread.sleep(500);          
            orderResponse = MessageKafkaListener.orderResponse;
            if (orderResponse == null) {
                Thread.sleep(3000);
            }
            if (orderResponse.getStock().equals("out")) {
                throw new ProductOutOfStockException("Product out of stock.");
            }
            return OrderMapper.mapperFromOrderResponse(orderResponse);       
        } catch(InterruptedException ex) {
            System.out.println(ex);
        }
        return null;
        
    }
   
    
}
