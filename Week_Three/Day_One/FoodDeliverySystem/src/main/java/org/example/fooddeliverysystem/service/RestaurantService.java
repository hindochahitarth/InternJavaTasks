package org.example.fooddeliverysystem.service;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.transaction.Transaction;
import jakarta.transaction.Transactional;
import org.example.fooddeliverysystem.dto.RestaurantRequestDTO;
import org.example.fooddeliverysystem.dto.RestaurantResponseDTO;
import org.example.fooddeliverysystem.entity.Restaurant;
import org.example.fooddeliverysystem.entity.RestaurantStatus;
import org.example.fooddeliverysystem.entity.TransactionLog;
import org.example.fooddeliverysystem.repository.RestaurantRepository;
import org.example.fooddeliverysystem.repository.TransactionLogRepository;
import org.springframework.cglib.core.Local;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class RestaurantService {

    private RestaurantRepository restaurantRepository;
    private TransactionLogRepository transactionLogRepository;

    public RestaurantService(RestaurantRepository restaurantRepository,TransactionLogRepository transactionLogRepository) {
        this.restaurantRepository = restaurantRepository;
        this.transactionLogRepository=transactionLogRepository;
    }

    @Transactional
    public Restaurant createRestaurant(RestaurantRequestDTO request) {
        Restaurant restaurant = new Restaurant();
        restaurant.setName(request.getName());
        restaurant.setAddress(request.getAddress());
        restaurant.setDescription(request.getDescription());
        restaurant.setEmail(request.getEmail());
        restaurant.setPhone(request.getPhone());
        // restaurant.setStatus(RestaurantStatus.ACTIVE);
        restaurant.setCity(request.getCity());
        restaurant.setStatus(RestaurantStatus.ACTIVE);
        Restaurant savedRestaurant=restaurantRepository.save(restaurant);

        TransactionLog log=new TransactionLog();
        log.setMessage("Created Restaurant "+savedRestaurant.getId());
        log.setTimestamp(LocalDateTime.now());
        transactionLogRepository.save(log);
        return savedRestaurant;


    }

    public Page<Restaurant> getAllRestaurants(Pageable pageable) {


        return restaurantRepository.findAll(pageable);
    }

    public void deleteRestaurantById(Long id) {
        restaurantRepository.deleteById(id);
    }

    public Restaurant updateRestaurant(Long id, RestaurantRequestDTO request) {
        Restaurant restaurant = restaurantRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Restaurant not found "));

        restaurant.setName(request.getName());
        restaurant.setPhone(request.getPhone());
        restaurant.setEmail(request.getEmail());
        restaurant.setDescription(request.getDescription());
        restaurant.setAddress(request.getAddress());
        restaurant.setCity(request.getCity());


        return restaurantRepository.save(restaurant);
    }

    public List<Restaurant> getRestaurantByName(String name) {
        return restaurantRepository.findByName(name);
    }
    public List<Restaurant> getRestaurantByCity(String city){
        return  restaurantRepository.findByCity(city);
    }
    public List<Restaurant> searchRestaurantsByName(String keyword) {
        if (keyword == null || keyword.trim().isEmpty()) {
            return restaurantRepository.findAll();
        }
        return restaurantRepository.searchByName(keyword.trim());
    }
    public RestaurantResponseDTO   toResponse(Restaurant restaurant){
        return RestaurantResponseDTO.builder()
                .id(restaurant.getId())
                .name(restaurant.getName())
                .description(restaurant.getDescription())
                .address(restaurant.getAddress())
                .phone(restaurant.getPhone())
                .email(restaurant.getEmail())
                .build();
    }
    public Restaurant toggleRestaurantStatus(Long id){
        Restaurant restaurant=restaurantRepository.findById(id).orElse(null);
        RestaurantStatus newStatus=(restaurant.getStatus() == RestaurantStatus.ACTIVE)?RestaurantStatus.INACTIVE:RestaurantStatus.ACTIVE;
        restaurant.setStatus(newStatus);
        Restaurant updatedRestaurant=restaurantRepository.save(restaurant);
        return updatedRestaurant;
    }


}
