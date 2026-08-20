package org.example.fooddeliverysystem.service;

import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import lombok.extern.slf4j.Slf4j;
import org.example.fooddeliverysystem.dto.RestaurantRequestDTO;
import org.example.fooddeliverysystem.dto.RestaurantResponseDTO;
import org.example.fooddeliverysystem.entity.*;
import org.example.fooddeliverysystem.exception.ResourceNotFoundException;
import org.example.fooddeliverysystem.exception.RestaurantAlreadyExists;
import org.example.fooddeliverysystem.mapper.RestaurantMapper;
import org.example.fooddeliverysystem.repository.CuisineTypeRepository;
import org.example.fooddeliverysystem.repository.RestaurantRepository;
import org.example.fooddeliverysystem.repository.TransactionLogRepository;
import org.example.fooddeliverysystem.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Slf4j
@Service
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;
    private final TransactionLogRepository transactionLogRepository;
    private final UserService userService;
    private final UserRepository userRepository;
    private RestaurantMapper restaurantMapper;
    private final CuisineTypeRepository cuisineTypeRepository;

    public RestaurantService(RestaurantMapper restaurantMapper, RestaurantRepository restaurantRepository,
                             TransactionLogRepository transactionLogRepository, UserService userService, UserRepository userRepository, CuisineTypeRepository cuisineTypeRepository) {
        this.restaurantRepository = restaurantRepository;
        this.transactionLogRepository = transactionLogRepository;
        this.restaurantMapper = restaurantMapper;
        this.userService = userService;
        this.userRepository = userRepository;
        this.cuisineTypeRepository = cuisineTypeRepository;

    }

    @Transactional
    public Restaurant createRestaurant(RestaurantRequestDTO request) {
        User owner=userRepository.findById(request.getOwnerId()).orElseThrow(() -> new ResourceNotFoundException("User Not found with id"+request.getOwnerId()));

        if(!owner.getRole().equals(Role.RESTAURANT_OWNER)){
            throw new RuntimeException("User is not restaurant owner");
        }
        Restaurant restaurant = restaurantMapper.toEntity(request);


        List<CuisineType> cuisineTypes =
                cuisineTypeRepository.findAllById(request.getCuisineTypeIds());
        restaurant.setStatus(RestaurantStatus.ACTIVE);

        Set<CuisineType> cuisineSet = new LinkedHashSet<>(cuisineTypes);
        restaurant.setCuisineTypes(cuisineSet);

        if (cuisineTypes.size() != request.getCuisineTypeIds().size()) {
            throw new ResourceNotFoundException(
                    "One or more cuisine types not found"
            );
        }

        Restaurant savedRestaurant = restaurantRepository.save(restaurant);
        log.info("Successfully created new Restaurant with ID: {} ",savedRestaurant.getId());

        TransactionLog log = new TransactionLog();
        log.setMessage("Created Restaurant " + savedRestaurant.getId());
        log.setTimestamp(LocalDateTime.now());
        transactionLogRepository.save(log);
        return savedRestaurant;
    }

    public Page<RestaurantResponseDTO> getAllRestaurants(Pageable pageable) {
        Page<Restaurant> restaurants=restaurantRepository.findAll(pageable);
        return restaurants.map(restaurant -> restaurantMapper.toResponseDTO(restaurant));
    }

    public void deleteRestaurantById(Long id) {

        restaurantRepository.deleteById(id);
    }

    public Restaurant updateRestaurant(Long id, RestaurantRequestDTO request) {
        Restaurant restaurant = restaurantRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Restaurant not found "));

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
//    public List<Restaurant> getRestaurantByCuisine(String cuisineName){
//
//    }
    public List<Restaurant> getRestaurantByCity(String city) {
        return restaurantRepository.findByCity(city);
    }

    public List<Restaurant> searchRestaurantsByName(String keyword) {
        if (keyword == null || keyword.trim().isEmpty()) {
            return restaurantRepository.findAll();
        }
        return restaurantRepository.searchByName(keyword.trim());
    }

    // public RestaurantResponseDTO toResponse(Restaurant restaurant){
    // return RestaurantResponseDTO.builder()
    // .id(restaurant.getId())
    // .name(restaurant.getName())
    // .description(restaurant.getDescription())
    // .address(restaurant.getAddress())
    // .phone(restaurant.getPhone())
    // .email(restaurant.getEmail())
    // .build();
    // }
    public Restaurant toggleRestaurantStatus(Long id) {
        Restaurant restaurant = restaurantRepository.findById(id).orElseThrow(() ->new  ResourceNotFoundException("No Restaurant with Restaurant ID :- " +id+" Found "));
        RestaurantStatus newStatus = (restaurant.getStatus() == RestaurantStatus.ACTIVE) ? RestaurantStatus.INACTIVE
                : RestaurantStatus.ACTIVE;
        restaurant.setStatus(newStatus);
        Restaurant updatedRestaurant = restaurantRepository.save(restaurant);
        return updatedRestaurant;
    }

}
