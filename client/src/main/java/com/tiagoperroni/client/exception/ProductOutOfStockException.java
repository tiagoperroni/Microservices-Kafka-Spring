package com.tiagoperroni.client.exception;

public class ProductOutOfStockException extends RuntimeException {

    public ProductOutOfStockException(String msg) {
       super(msg);
    }
    
}
