package com.tiagoperroni.client.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class OrderResponseDTO {
    
    private Integer id;
    private String clientName;
    private String productName;
    private Integer quantity;
    private Double total;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime created_at;


 
}
