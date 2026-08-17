package org.example.fooddeliverysystem.controller;

import java.util.List;

import lombok.extern.slf4j.Slf4j;
import org.example.fooddeliverysystem.dto.RestaurantRequestDTO;
import org.example.fooddeliverysystem.entity.Restaurant;
import org.example.fooddeliverysystem.service.RestaurantService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController // used to return JSON data
@RequestMapping("/api/restaurants") // base path for all API's
public class    RestaurantController {

    private final RestaurantService restaurantService;

    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    // USING @RequestMapping(method=RequestMethod.GET)
    @GetMapping("/get-all-restaurants")
    public ResponseEntity<Page<Restaurant>> getAllRestaurant(

            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Restaurant> restaurants = restaurantService.getAllRestaurants(pageable);
        log.info("Fetching all restaurants ");
        return ResponseEntity.status(HttpStatus.OK).body(restaurants);
    }
// @RequestMapping(value="/create",method=RequestMethod.POST)
    // post requests to /api/restaurants/add-restaurant
    @PreAuthorize("hasRole('RESTAURANT_OWNER')")
    @PostMapping("/add-restaurant")
    public ResponseEntity<Restaurant> createRestaurant(@RequestBody RestaurantRequestDTO request) {

        Restaurant savedRestaurant = restaurantService.createRestaurant(request);
        log.info("Creating restaurant");

        return new ResponseEntity<>(savedRestaurant, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete-restaurant/{id}")
    public ResponseEntity<HttpStatus> deleteRestaurantById(@PathVariable Long id) {
        log.info("Deleting Restaurant ");

        restaurantService.deleteRestaurantById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/update-restaurant/{id}")
    public ResponseEntity<Restaurant> updateRestaurant(@PathVariable Long id,
            @RequestBody RestaurantRequestDTO request) {
        log.info("Updating restaurant");
        Restaurant updatedRestaurant = restaurantService.updateRestaurant(id, request)  ;
        return ResponseEntity.ok(updatedRestaurant);
    }

    @GetMapping("/{name}")
    public ResponseEntity<List<Restaurant>> getRestaurantByName(@PathVariable String name) {
        log.info("Fetching Restaurant ");
        List<Restaurant> restaurants = restaurantService.getRestaurantByName(name);
        if(restaurants.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return ResponseEntity.status(HttpStatus.OK).body(restaurants);

    }

    @GetMapping("/city/{city}")
    public ResponseEntity<List<Restaurant>> getRestaurantByCity(@PathVariable String city) {
        log.info("Fetching Restaurant By City ");
        List<Restaurant> restaurants = restaurantService.getRestaurantByCity(city);
        return ResponseEntity.status(HttpStatus.OK).body(restaurants);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Restaurant>> searchRestaurants(@RequestParam String keyword) {
        List<Restaurant> results = restaurantService.searchRestaurantsByName(keyword);
        return ResponseEntity.status(HttpStatus.OK).body(results);
    }

    @PatchMapping("/toggle-restaurant-status/{id}")
    public ResponseEntity<Restaurant> toggleRestaurantStatus(@PathVariable Long id) {
        log.info("Toggling Restaurant Status");
        Restaurant restaurant = restaurantService.toggleRestaurantStatus(id);
        return ResponseEntity.status(HttpStatus.OK).body(restaurant);
    }

}


