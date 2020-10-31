package edu.northeastern.cs5500.delivery.model;


import java.util.ArrayList;


import edu.northeastern.cs5500.delivery.model.user.Payment;
import edu.northeastern.cs5500.delivery.model.user.User;
import lombok.Data;

@Data
public class Order {
	private ArrayList<FoodItem> dishOrder;
    private String orderID;
    private User user;
    private OrderStatus status;
    private Double totalCost;
    private String deliveryAddress;
    private Payment paymentMethod;


}
