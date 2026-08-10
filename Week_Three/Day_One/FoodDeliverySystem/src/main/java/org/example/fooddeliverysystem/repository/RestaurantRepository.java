package org.example.fooddeliverysystem.repository;

import java.util.List;

import org.example.fooddeliverysystem.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

    List<Restaurant> findByName(String name);

    @Query
    List<Restaurant> findByCity(@Param("city") String city);

    @Query("SELECT r FROM Restaurant r WHERE r.name LIKE %:keyword%")
    List<Restaurant> searchByName(@Param("keyword") String keyword);

}
