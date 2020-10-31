package edu.northeastern.cs5500.delivery.model;


import java.util.ArrayList;


import lombok.Data;

@Data
public class Order {
	private ArrayList<FoodItems> dishOrder;
    private String orderID;
    private User userID;
    private OrderStatus status;



	@Data
    public static class User{

    }

    @Data
    public static class FoodItems{
        private Double price;
        private String foodName;
    }
}
