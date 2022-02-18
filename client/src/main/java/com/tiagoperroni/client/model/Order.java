package com.tiagoperroni.client.model;

import lombok.Data;

@Data
public class Order {
 
    private String clientName;
    private Integer productId;
    private Integer quantity;  

    public static Order convert(Order order) {
        var newOrder = new Order();
        newOrder.setClientName(order.getClientName());
        newOrder.setProductId(order.getProductId());   
        newOrder.setQuantity(order.getQuantity());
        return newOrder;
    }
}
