package org.example.fooddeliverysystem.entity;

import jakarta.persistence.*;

import java.beans.FeatureDescriptor;

@Entity
@Table(name="orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="customer_id",nullable = false)
    private User customer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="restaurant_id",nullable = false)
    private Restaurant restaurant;



}
