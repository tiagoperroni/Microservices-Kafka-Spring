package com.tiagoperroni.client.exception;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MessageError {

    private int statusCode;
    private String message;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime timestamp;
    
}
