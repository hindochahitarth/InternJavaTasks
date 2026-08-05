package org.example.fooddeliverysystem.service;

import org.example.fooddeliverysystem.model.FoodItem;
import org.springframework.stereotype.Service;
import java.util.*;
import java.util.HashMap;

@Service
public class RestaurantService {
        private final Map<String, FoodItem> menu =new HashMap<>();

        public RestaurantService(){
            menu.put("Burger",new FoodItem("Burger",8.99));
        }
}

// service classes is used to provide business logic
// auto detected by spring container

