package org.example.fooddeliverysystem.exception;

public class MenuItemNotFoundException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public MenuItemNotFoundException (String msg) {
        super(msg);
    }
}
