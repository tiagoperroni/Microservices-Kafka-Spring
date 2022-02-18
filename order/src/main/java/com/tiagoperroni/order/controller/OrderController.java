package com.tiagoperroni.order.controller;

import java.util.List;

import com.tiagoperroni.order.model.Order;
import com.tiagoperroni.order.service.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public ResponseEntity<List<Order>> getAll() {
        return new ResponseEntity<>(this.orderService.getAll(), HttpStatus.OK);
    }

}
