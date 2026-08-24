package org.example.fooddeliverysystem.service;

import java.util.List;

import lombok.extern.slf4j.Slf4j;
import org.example.fooddeliverysystem.dto.MenuItemRequestDTO;
import org.example.fooddeliverysystem.entity.MenuItem;
import org.example.fooddeliverysystem.enums.MenuItemStatus;
import org.example.fooddeliverysystem.entity.Restaurant;
import org.example.fooddeliverysystem.exception.InvalidMenuItemPriceException;
import org.example.fooddeliverysystem.exception.ResourceNotFoundException;
import org.example.fooddeliverysystem.repository.MenuItemRepository;
import org.example.fooddeliverysystem.repository.RestaurantRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MenuItemService {
    private final MenuItemRepository menuItemRepository;
    private final RestaurantRepository restaurantRepository;

    public MenuItemService(MenuItemRepository menuItemRepository, RestaurantRepository restaurantRepository) {
        this.menuItemRepository = menuItemRepository;
        this.restaurantRepository = restaurantRepository;
    }

    public MenuItem createMenuItem(MenuItemRequestDTO request) {
        log.info("Creating Menu Item for Restaurant ID "+request.getRestaurantId());
        Restaurant   restaurant = restaurantRepository.findById(request.getRestaurantId()).orElseThrow(() ->
        {
            log.warn("Failed to Create Menu Item");
            return new ResourceNotFoundException("Restaruant not Found");
        });

        MenuItem menuItem = new MenuItem();
        menuItem.setName(request.getName());
        menuItem.setDescription(request.getDescription());
        menuItem.setPrice(request.getPrice());
        menuItem.setImageUrl(request.getImageUrl());
        menuItem.setStatus(
                request.getMenuItemStatus() != null ? request.getMenuItemStatus() : MenuItemStatus.AVAILABLE);
        menuItem.setRestaurant(restaurant);
        menuItem.setCategory(request.getCategory());

        MenuItem savedItem=menuItemRepository.save(menuItem);
        log.info("Successfully created Restaurant with ID "+savedItem.getId());
        return savedItem;
    }

    @Cacheable(value="MenuItem", key="#id")
    public MenuItem getMenuItemById(Long id) {

        log.debug("Fetching Menu Details of ID "+id);

        return menuItemRepository.findById(id).orElse(null);
    }

    public MenuItem updateMenuItem(Long id, MenuItemRequestDTO request) {

        log.info("Updating Menu details ");
        MenuItem menuItem = menuItemRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("MenuItem with id "+id+" not found "));
        menuItem.setName(request.getName());
        menuItem.setDescription(request.getDescription());

        menuItem.setPrice(request.getPrice());

        //log.warn(String.valueOf(request.getPrice().getClass().getSimpleName()));
        menuItem.setImageUrl(request.getImageUrl());
        menuItem.setCategory(request.getCategory());

        return menuItemRepository.save(menuItem);

    }

    public List<MenuItem> getMenuByRestaurantId(Long restaurantId) {
        return menuItemRepository.findByRestaurantId(restaurantId);
    }

    public void deleteMenuItemById(Long id) {
        MenuItem menuItem = menuItemRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("MenuItem with id "+id+" not found "));

        log.info("Deleting Menu Item with ID ",id);
        menuItemRepository.deleteById(id);
    }

    public MenuItem updateMenuItemPrice(Long id, MenuItemRequestDTO request) {
        log.info("Updating Menu Item Price ");
        if(request.getPrice() <=0){
            throw new InvalidMenuItemPriceException("Price must be greater than 0");
        }
        MenuItem menuItem = menuItemRepository.findById(id).orElse(null);
        menuItem.setPrice((request.getPrice()));

        return menuItemRepository.save(menuItem);

    }

    public List<MenuItem> getMenuByCategory(Long restaurantId, String category) {
        log.info("Fetching Menu BY Category ");
        return menuItemRepository.findByRestaurantIdAndCategory(restaurantId, category);
    }

}
