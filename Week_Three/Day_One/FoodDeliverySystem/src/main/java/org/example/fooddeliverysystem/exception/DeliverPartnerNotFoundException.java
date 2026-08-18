package org.example.fooddeliverysystem.exception;

public class DeliverPartnerNotFoundException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public DeliverPartnerNotFoundException(String msg) {
        super(msg);
    }
}
