package org.example.fooddeliverysystem.exception;

public class InvalidMenuItemPrice extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public InvalidMenuItemPrice(String msg) {
        super(msg);
    }

}
