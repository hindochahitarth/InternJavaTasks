package org.example.fooddeliverysystem.exception;

public class RestaurantAlreadyExists extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public RestaurantAlreadyExists(String msg) {

        super(msg);
    }
}
