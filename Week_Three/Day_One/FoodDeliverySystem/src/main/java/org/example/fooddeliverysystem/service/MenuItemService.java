package org.example.fooddeliverysystem.service;

import java.util.List;
import java.util.Optional;

import org.example.fooddeliverysystem.dto.MenuItemRequestDTO;
import org.example.fooddeliverysystem.entity.MenuItem;
import org.example.fooddeliverysystem.entity.Restaurant;
import org.example.fooddeliverysystem.repository.MenuItemRepository;
import org.example.fooddeliverysystem.repository.RestaurantRepository;
import org.springframework.stereotype.Service;

@Service
public class MenuItemService {
    private final MenuItemRepository menuItemRepository;
    private final RestaurantRepository restaurantRepository;

    public MenuItemService(MenuItemRepository menuItemRepository, RestaurantRepository restaurantRepository) {
        this.menuItemRepository = menuItemRepository;
        this.restaurantRepository = restaurantRepository;
    }

    public MenuItem createMenuItem(MenuItemRequestDTO request) {
        Optional<Restaurant> restaurant = restaurantRepository.findById(request.getRestaurantId());
        MenuItem menuItem = new MenuItem();
        menuItem.setName(request.getName());
        menuItem.setDescription(request.getDescription());
        menuItem.setPrice(request.getPrice());
        menuItem.setImageUrl(request.getImageUrl());
        menuItem.setRestaurant(restaurant.orElse(null));
        menuItem.setCategory(request.getCategory());

        return menuItemRepository.save(menuItem);
    }

    public MenuItem getMenuItemById(Long id) {

        return menuItemRepository.findById(id).orElse(null);
    }

    public MenuItem updateMenuItem(Long id, MenuItemRequestDTO request) {
        MenuItem menuItem = menuItemRepository.findById(id).orElse(null);
        menuItem.setName(request.getName());
        menuItem.setDescription(request.getDescription());
        menuItem.setPrice(request.getPrice());
        menuItem.setImageUrl(request.getImageUrl());
        menuItem.setCategory(request.getCategory());
        return menuItemRepository.save(menuItem);

    }

    public List<MenuItem> getMenuByRestaurantId(Long restaurantId) {
        return menuItemRepository.findByRestaurantId(restaurantId);
    }

    public void deleteMenuItemById(Long id) {
        menuItemRepository.deleteById(id);
    }

    public MenuItem updateMenuItemPrice(Long id, MenuItemRequestDTO request) {
        MenuItem menuItem = menuItemRepository.findById(id).orElse(null);
        menuItem.setPrice((request.getPrice()));

        return menuItemRepository.save(menuItem);

    }

    public List<MenuItem> getMenuByCategory(Long restaurantId, String category) {

        return menuItemRepository.findByRestaurantIdAndCategory(restaurantId, category);
    }

}
