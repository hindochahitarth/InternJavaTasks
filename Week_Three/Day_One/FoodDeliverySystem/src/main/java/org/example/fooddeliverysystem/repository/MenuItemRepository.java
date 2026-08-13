package org.example.fooddeliverysystem.repository;

import java.util.List;

import org.example.fooddeliverysystem.entity.MenuItem;
import org.example.fooddeliverysystem.entity.MenuItemStatus;
import org.example.fooddeliverysystem.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuItemRepository extends JpaRepository<MenuItem, Long> {

    List<MenuItem> findByRestaurantId(Long restaurantId);

    List<MenuItem> findByRestaurantIdAndCategory(Long restaurantId, String category);

}
