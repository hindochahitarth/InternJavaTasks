package org.example.fooddeliverysystem.repository;

import org.example.fooddeliverysystem.entity.CuisineType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CuisineTypeRepository extends JpaRepository<CuisineType, Long> {
}