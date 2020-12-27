package edu.northeastern.cs5500.delivery.model;

import lombok.Data;
import org.bson.types.ObjectId;

@Data
public class FoodItem {
    private Double price;
    private int quantity;
    private String name;
    private String imageUrl;
    private String restaurant;
}
