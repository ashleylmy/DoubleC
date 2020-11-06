package edu.northeastern.cs5500.delivery.model;

import edu.northeastern.cs5500.delivery.model.Restaurant.Restaurant;
import edu.northeastern.cs5500.delivery.model.user.Payment;
import edu.northeastern.cs5500.delivery.model.user.User;
import java.util.ArrayList;
import lombok.Data;
import org.bson.types.ObjectId;

@Data
public class Order implements Model {
    private ObjectId orderId;
    private ArrayList<FoodItem> dishOrder;
    private User user;
    private OrderStatus status;
    private Double totalCost;
    private String deliveryAddress;
    private Payment paymentMethod;
    private Restaurant restaurant;
    private int rating;

    @Override
    public ObjectId getId() {
        return null;
    }

    @Override
    public void setId(ObjectId id) {}
}
