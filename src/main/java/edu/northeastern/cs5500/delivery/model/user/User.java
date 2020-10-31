package edu.northeastern.cs5500.delivery.model.user;

import java.util.ArrayList;
import java.util.Date;

import edu.northeastern.cs5500.delivery.model.FoodItem;
import edu.northeastern.cs5500.delivery.model.Model;
import lombok.Data;
import org.bson.types.ObjectId;

import javax.annotation.Nonnull;

@Data
public class User implements Model {
    private ObjectId id;
    private Date registerDate;
    private String email;
    private String password;
    private String userName;
    private String address;
    private Integer phoneNumber;
    private ArrayList<Order> orderHistory = new ArrayList<>();
    private ArrayList<FoodItem> cart;
    private ArrayList<Payment> paymentMethods;
    private boolean loginStatus;

    //to sign up as a new user needs email, password, username
    public User(String email, String password, String userName) {
        this.email = email;
        this.password = password;
        this.userName = userName;
    }

    @Override
    public void setId(ObjectId id) { }


    @Data
    public static class Order implements Model{
        private ObjectId id;
        private ArrayList<FoodItem> orderItems;
        private String orderStatus;
        private String restaurant;
        private String deliveryDestination;
        private Payment billingInfo;
        private Integer totalPrice;
        private User user;

        @Override
        public void setId(ObjectId id) {

        }
        public Order getOrder(@Nonnull ObjectId uuid) {
            return this;
        }
    }
}
