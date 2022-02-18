package com.tiagoperroni.client.mapper;

import java.time.LocalDateTime;

import com.tiagoperroni.client.dto.OrderResponseDTO;
import com.tiagoperroni.client.model.OrderResponse;

import org.springframework.beans.BeanUtils;

public class OrderMapper {

    public static OrderResponseDTO mapperFromOrderResponse(OrderResponse orderResponse) {
        var orderResponseDTO = new OrderResponseDTO();
        BeanUtils.copyProperties(orderResponse, orderResponseDTO);
        orderResponseDTO.setCreated_at(LocalDateTime.now());
        return orderResponseDTO;
    }
    
}
