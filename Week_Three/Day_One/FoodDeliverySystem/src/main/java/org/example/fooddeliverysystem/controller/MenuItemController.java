package org.example.fooddeliverysystem.controller;

import java.util.List;

import lombok.extern.slf4j.Slf4j;
import org.example.fooddeliverysystem.dto.MenuItemRequestDTO;
import org.example.fooddeliverysystem.entity.MenuItem;
import org.example.fooddeliverysystem.service.MenuItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
@RestController
@RequestMapping("/api/menu-items")
public class MenuItemController {
    private final MenuItemService menuItemService;

    public MenuItemController(MenuItemService menuItemService) {
        this.menuItemService = menuItemService;
    }

    @PostMapping("/create-menu-items")
    public ResponseEntity<MenuItem> createMenuItem(@RequestBody MenuItemRequestDTO request) {

        log.info("Creating menu Item ");
        MenuItem menuItem = menuItemService.createMenuItem(request);
        return new ResponseEntity<>(menuItem, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MenuItem> getMenuItemById(@PathVariable("id") Long id) {
        log.info("Fetching Menu Item ....");
        MenuItem menuItem = menuItemService.getMenuItemById(id);
        return ResponseEntity.status(HttpStatus.OK).body(menuItem);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<MenuItem> updateMenuItem(@PathVariable Long id, @RequestBody MenuItemRequestDTO request) {
        log.info("Updating Menuitem ");
        MenuItem menuItem = menuItemService.updateMenuItem(id, request);
        return ResponseEntity.status(HttpStatus.OK).body(menuItem);
    }

    @GetMapping("/restaurant/{restaurantId}")
    public ResponseEntity<List<MenuItem>> getMenuByRestaurant(@PathVariable Long restaurantId) {
        log.info("Fetching Menu By Restaurant ");
        List<MenuItem> menuItem = menuItemService.getMenuByRestaurantId(restaurantId);
        return ResponseEntity.status(HttpStatus.OK).body(menuItem);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<MenuItem> deleteMenuItemById(@PathVariable Long id) {
        log.info("Deleting Menu item ");
        menuItemService.deleteMenuItemById(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/update-price/{id}/price")
    public ResponseEntity<MenuItem> updateMenuItemByPrice(@PathVariable Long id, @RequestParam Double price) {
        log.info("Updating menu item price ");
        MenuItemRequestDTO menuItemRequestDTO = new MenuItemRequestDTO();
        menuItemRequestDTO.setPrice(price);

        MenuItem updated = menuItemService.updateMenuItemPrice(id, menuItemRequestDTO);
        return ResponseEntity.ok(updated);
    }

    @GetMapping("/restaurant/{restaurantId}/category/{category}")
    public ResponseEntity<List<MenuItem>> getMenuByRestaurantCategory(@PathVariable Long restaurantId,
            @PathVariable String category) {
        log.info("Fetching menu by restaurant category "+category);
        List<MenuItem> menuItems = menuItemService.getMenuByCategory(restaurantId, category);
        return ResponseEntity.status(HttpStatus.OK).body(menuItems);
    }

}
