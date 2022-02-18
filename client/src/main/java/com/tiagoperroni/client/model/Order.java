package com.tiagoperroni.client.model;

import lombok.Data;

@Data
public class Order {
 
    private String clientName;
    private Integer productId;
    private Integer quantity; 

   
}
