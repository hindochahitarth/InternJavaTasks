package org.example.fooddeliverysystem.model;

import java.util.List;

public class Order {
    private String orderId;
    private List<String> orderItems;
    private double amount;

    public Order(String orderId, List<String> orderItems, double amount) {
        this.orderId = orderId;
        this.orderItems = orderItems;
        this.amount = amount;
    }

    public String getOrderId() {
        return orderId;
    }

    public List<String> getOrderItems() {
        return orderItems;
    }

    public double getAmount() {
        return amount;
    }
}
