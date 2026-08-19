package org.example.fooddeliverysystem.controller;

import org.example.fooddeliverysystem.entity.CuisineType;
import org.example.fooddeliverysystem.service.CuisineTypeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cuisines")
public class CuisineTypeController {

    private final CuisineTypeService cuisineTypeService;

    public CuisineTypeController(CuisineTypeService cuisineTypeService) {
        this.cuisineTypeService = cuisineTypeService;
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/add-cuisine")
    public ResponseEntity<CuisineType> createCuisine(
            @RequestBody CuisineType cuisineType) {

        CuisineType savedCuisine =
                cuisineTypeService.createCuisine(cuisineType);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(savedCuisine);
    }

    @GetMapping("/getCuisines")
    public ResponseEntity<List<CuisineType>> getAllCuisines() {

        return ResponseEntity.ok(
                cuisineTypeService.getAllCuisines()
        );
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<CuisineType> getCuisineById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                cuisineTypeService.getCuisineById(id)
        );
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<CuisineType> updateCuisine(
            @PathVariable Long id,
            @RequestBody CuisineType cuisineType) {

        return ResponseEntity.ok(
                cuisineTypeService.updateCuisine(id, cuisineType)
        );
    }
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCuisine(
            @PathVariable Long id) {

        cuisineTypeService.deleteCuisine(id);

        return ResponseEntity.noContent().build();
    }
}