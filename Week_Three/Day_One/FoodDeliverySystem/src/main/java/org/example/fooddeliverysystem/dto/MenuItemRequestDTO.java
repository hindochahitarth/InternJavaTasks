package org.example.fooddeliverysystem.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.example.fooddeliverysystem.entity.MenuItemStatus;

public class MenuItemRequestDTO {

    @NotBlank(message = "Item Name is Required ")
    private String name;

    private String description;

    @NotBlank(message = "Category is Required ")
    private String category;

    @NotNull(message = "Price is Required ")
    @Positive(message = "Price must be positive ")
    private Double price;

    private String imageUrl;

    @NotNull(message = "Restaurant ID is required ")
    private Long restaurantId;
    private MenuItemStatus menuItemStatus;

    public MenuItemStatus getMenuItemStatus() {
        return menuItemStatus;
    }

    public void setMenuItemStatus(MenuItemStatus menuItemStatus) {
        this.menuItemStatus = menuItemStatus;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return category;
    }

    public Double getPrice() {
        return price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public Long getRestaurantId() {
        return restaurantId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setRestaurantId(Long restaurantId) {
        this.restaurantId = restaurantId;
    }
}
