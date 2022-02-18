package com.tiagoperroni.client.model;

import org.springframework.beans.BeanUtils;

import lombok.Data;

@Data
public class OrderResponse {
    
    private Integer id;
    private String clientName;
    private Integer productId;
    private String productName;
    private Integer quantity;
    private Double total;
    private String stock;

    public OrderResponse create(OrderResponse orderResponse) {
        var newOrderResponse = new OrderResponse();
        BeanUtils.copyProperties(orderResponse, newOrderResponse);
        return newOrderResponse;
    }
}
