package org.example.fooddeliverysystem.mapper;

import org.example.fooddeliverysystem.dto.RestaurantRequestDTO;
import org.example.fooddeliverysystem.dto.RestaurantResponseDTO;
import org.example.fooddeliverysystem.entity.Restaurant;
import org.mapstruct.Mapper;
import java.util.*;

@Mapper(componentModel = "spring")
public interface RestaurantMapper {

    Restaurant toEntity(RestaurantRequestDTO dto);


    RestaurantResponseDTO toResponseDTO(Restaurant restaurant);
}
