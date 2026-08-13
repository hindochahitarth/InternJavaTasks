package org.example.fooddeliverysystem.entity;

import jakarta.persistence.*;

@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private Integer age;


    @Enumerated(EnumType.STRING)
    private Gender gender;

    private String address;

    private String emailId;

    private String password;



}
