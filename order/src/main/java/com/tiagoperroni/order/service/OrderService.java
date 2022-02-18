package com.tiagoperroni.order.service;

import java.util.ArrayList;
import java.util.List;

import com.tiagoperroni.order.model.Order;

import org.springframework.stereotype.Service;

@Service
public class OrderService { 
    
   public static List<Order> orders = new ArrayList<>();

   public List<Order> getAll() {
       return orders;
   }

    
}
