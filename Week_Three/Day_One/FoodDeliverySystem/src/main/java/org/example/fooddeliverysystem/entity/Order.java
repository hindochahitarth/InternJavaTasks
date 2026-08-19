package org.example.fooddeliverysystem.entity;

import jakarta.persistence.*;

import java.beans.FeatureDescriptor;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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

    @OneToMany(mappedBy = "order",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<OrderItem> items=new ArrayList<>();

    @Column(nullable = false)
    private Double totalAmount;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus=OrderStatus.PENDING;

    private String deliveryAddress;
    private String note;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "delivery_partner_id")
    private User deliveryPartner;

    private LocalDateTime orderTime;
    private  LocalDateTime estmatedDeliveryTime;
    private LocalDateTime deliveredTime;

    @PrePersist
    protected void onCreate(){
        orderTime=LocalDateTime.now();
        estmatedDeliveryTime=LocalDateTime.now().plusMinutes(30);
    }
    @PreUpdate
    protected void onUpdate(){
        if(orderStatus==OrderStatus.DELIVERED && deliveredTime==null){
            deliveredTime=LocalDateTime.now();
        }
    }
    public void addOrderItem(OrderItem orderItem) {
        orderItem.setOrder(this);
        this.items.add(orderItem);
    }

}
