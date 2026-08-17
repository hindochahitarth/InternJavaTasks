package org.example.fooddeliverysystem.dto;

import org.example.fooddeliverysystem.entity.CuisineType;
import org.example.fooddeliverysystem.entity.MenuItemStatus;

import java.util.List;

public class RestaurantRequestDTO {
    // public List<CuisineType> getCuisineType() {
    // return cuisineType;
    // }
    //
    // public void setCuisineType(List<CuisineType> cuisineType) {
    // this.cuisineType = cuisineType;
    // }

    private String name;
    private String description;
    private String email;

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    private String address;
    private String phone;
    private String city;
    private Long ownerId;
    private String ownerName;

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }
// private List<CuisineType> cuisineType;

    public RestaurantRequestDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}
