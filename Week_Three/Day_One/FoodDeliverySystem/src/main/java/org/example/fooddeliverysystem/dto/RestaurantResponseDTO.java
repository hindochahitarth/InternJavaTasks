package org.example.fooddeliverysystem.dto;

import lombok.Builder;

@Builder
public class RestaurantResponseDTO {
    private Long id;
    private String name;
    private String description;
    private String address;
    private String email;
    private String phone;

}
