package com.tiagoperroni.order.model;

import org.springframework.beans.BeanUtils;

import lombok.Data;

@Data
public class Order {

    private Integer id;
    private String clientName;
    private Integer productId;
    private String productName;
    private Integer quantity;
    private Double total;
    private String stock;

    public Order create(Order order) {
        var newOrder = new Order();
        BeanUtils.copyProperties(order, newOrder);
        return newOrder;
    }
    
}
