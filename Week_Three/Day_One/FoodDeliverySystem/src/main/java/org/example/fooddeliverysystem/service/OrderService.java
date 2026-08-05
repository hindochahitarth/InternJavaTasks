package org.example.fooddeliverysystem.service;

import org.springframework.stereotype.Service;

@Service
public class OrderService {
    private final RestaurantService restaurantService;

    public OrderService(RestaurantService restaurantService){
        this.restaurantService=restaurantService;
    }

}
