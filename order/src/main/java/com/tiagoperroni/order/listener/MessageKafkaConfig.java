package com.tiagoperroni.order.listener;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tiagoperroni.order.model.Order;
import com.tiagoperroni.order.model.Product;
import com.tiagoperroni.order.service.KafkaService;
import com.tiagoperroni.order.service.OrderService;
import com.tiagoperroni.order.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class MessageKafkaConfig {

    @Autowired
    private ProductService productService;

    @Autowired
    private KafkaService kafkaService;

    @KafkaListener(topics = "${topic.shop-cliente}", groupId = "${spring.kafka.consumer.group-id}")
    public void getOrder(String orderString) throws JsonMappingException, JsonProcessingException {

        log.info("New order received: {}", orderString);

        ObjectMapper mapper = new ObjectMapper();
        Order order = mapper.readValue(orderString, Order.class);

        var product = this.productService.findById(order.getProductId());
        if (this.valid(order, product)) { 
            log.info("Product not in stock: {}", product.getName());
            this.sendOrderNotStock(order);
            return;

        }        
            
            order.setProductName(product.getName());
            order.setId(1);
            order.setTotal(product.getPrice() * order.getQuantity());
            order.setStock("ok");
            
            OrderService.orders.add(order);                    
            order.create(order);      
            
            this.sendOrder(order);

    }
    
    public void sendOrder(Order order) throws JsonMappingException, JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();  
   
        String orderMessage = mapper.writeValueAsString(order);
        kafkaService.sendMessage(orderMessage);

        log.info("New order was sending: {}", order);     

    }

    public void sendOrderNotStock(Order order) throws JsonMappingException, JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();

        order.setStock("out");
   
        String orderMessage = mapper.writeValueAsString(order);
        kafkaService.sendMessage(orderMessage);    

    }

    public boolean valid(Order order, Product product) {
        if (order.getQuantity() > product.getQuantity()) {
            return true;
        }
        return false;
    }

    
}
