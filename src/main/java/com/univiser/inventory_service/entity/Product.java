package com.univiser.inventory_service.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//Getters, Setters and Constructors using Lombok
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "products")

public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "Product_Name")
    private String productName;

    @Column(name = "Quantity")
    private int quantity;

    @Column(name = "Price")
    private double price;

}


