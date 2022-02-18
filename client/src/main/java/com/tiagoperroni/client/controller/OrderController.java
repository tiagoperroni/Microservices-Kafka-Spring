package com.tiagoperroni.client.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.tiagoperroni.client.model.Order;
import com.tiagoperroni.client.model.OrderResponse;
import com.tiagoperroni.client.service.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity<OrderResponse> save(@RequestBody Order order) throws JsonProcessingException {
        return new ResponseEntity<>(this.orderService.save(order), HttpStatus.CREATED);
    }
}
