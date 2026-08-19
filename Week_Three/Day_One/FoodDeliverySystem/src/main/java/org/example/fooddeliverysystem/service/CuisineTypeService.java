package org.example.fooddeliverysystem.service;

import org.example.fooddeliverysystem.entity.CuisineType;
import org.example.fooddeliverysystem.exception.ResourceNotFoundException;
import org.example.fooddeliverysystem.repository.CuisineTypeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Service
public class CuisineTypeService {

    private final CuisineTypeRepository cuisineTypeRepository;

    public CuisineTypeService(CuisineTypeRepository cuisineTypeRepository) {
        this.cuisineTypeRepository = cuisineTypeRepository;
    }

    public CuisineType createCuisine(CuisineType cuisineType) {
        return cuisineTypeRepository.save(cuisineType);
    }

    public List<CuisineType> getAllCuisines() {
        List<CuisineType> rawCuisines = cuisineTypeRepository.findAll();

        Set<CuisineType> uniqueCuisines = new LinkedHashSet<>(rawCuisines);

        return new ArrayList<>(uniqueCuisines);
    }

    public CuisineType getCuisineById(Long id) {
        return cuisineTypeRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Cuisine not found with id: " + id
                        ));
    }

    public CuisineType updateCuisine(Long id, CuisineType cuisineType) {

        CuisineType existingCuisine = cuisineTypeRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Cuisine not found with id: " + id
                        ));

        existingCuisine.setCuisineName(cuisineType.getCuisineName());

        return cuisineTypeRepository.save(existingCuisine);
    }

    public void deleteCuisine(Long id) {

        CuisineType cuisineType = cuisineTypeRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Cuisine not found with id: " + id
                        ));

        cuisineTypeRepository.delete(cuisineType);
    }
}