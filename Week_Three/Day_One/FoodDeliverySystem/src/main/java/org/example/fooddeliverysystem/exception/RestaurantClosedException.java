package org.example.fooddeliverysystem.exception;

public class RestaurantClosedException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    public RestaurantClosedException(String msg) {
        super(msg);
    }
}

