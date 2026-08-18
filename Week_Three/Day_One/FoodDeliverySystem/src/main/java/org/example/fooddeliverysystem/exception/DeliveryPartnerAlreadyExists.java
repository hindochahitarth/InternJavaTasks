package org.example.fooddeliverysystem.exception;

public class DeliveryPartnerAlreadyExists extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public DeliveryPartnerAlreadyExists(String msg) {
        super(msg);
    }
}
