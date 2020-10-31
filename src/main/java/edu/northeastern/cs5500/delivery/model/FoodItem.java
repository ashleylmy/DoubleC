package edu.northeastern.cs5500.delivery.model;

import lombok.Data;

@Data
public class FoodItem {
    private int price, quantity;
    private String name;
    //Should Food Item have restaurant attribute?
    private String restaurant;//need to have restaurant class

}
