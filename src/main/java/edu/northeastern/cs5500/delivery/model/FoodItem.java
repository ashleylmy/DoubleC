package edu.northeastern.cs5500.delivery.model;

import lombok.Data;

@Data
public class FoodItem {
    private Double price;
    private int quantity;
    private String name;
    // Should Food Item have restaurant attribute?
    private String imageUrl;
    private String restaurant; // need to have restaurant class
}
