package org.example.fooddeliverysystem.controller;

import java.util.List;

import org.example.fooddeliverysystem.dto.RestaurantRequestDTO;
import org.example.fooddeliverysystem.entity.Restaurant;
import org.example.fooddeliverysystem.service.RestaurantService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // used to return JSON data
@RequestMapping("/api/restaurants") // base path for all API's
public class RestaurantController {

    private final RestaurantService restaurantService;

    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    // USING @RequestMapping(method=RequestMethod.GET)
    @GetMapping("/get-all-restaurants")
    public ResponseEntity<List<Restaurant>> getAllRestaurant() {
        List<Restaurant> restaurants = restaurantService.getAllRestaurants();
        return ResponseEntity.status(HttpStatus.OK).body(restaurants);
    }

    // @RequestMapping(value="/create",method=RequestMethod.POST)
    // post requests to /api/restaurants/add-restaurant
    @PostMapping("/add-restaurant")
    public ResponseEntity<Restaurant> createRestaurant(@RequestBody RestaurantRequestDTO request) {
        Restaurant savedRestaurant = restaurantService.createRestaurant(request);
        return new ResponseEntity<>(savedRestaurant, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete-restaurant/{id}")
    public ResponseEntity<HttpStatus> deleteRestaurantById(@PathVariable Long id) {
        restaurantService.deleteRestaurantById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/update-restaurant/{id}")
    public ResponseEntity<Restaurant> updateRestaurant(@PathVariable Long id,
            @RequestBody RestaurantRequestDTO request) {
        Restaurant updatedRestaurant = restaurantService.updateRestaurant(id, request);
        return ResponseEntity.ok(updatedRestaurant);
    }

}
