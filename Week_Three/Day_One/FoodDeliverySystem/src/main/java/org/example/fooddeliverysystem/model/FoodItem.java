package org.example.fooddeliverysystem.model;

public class FoodItem {

    private String name;
    private Double price;

    public FoodItem(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }
}
