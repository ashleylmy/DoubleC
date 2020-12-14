package edu.northeastern.cs5500.delivery.model.user;

import edu.northeastern.cs5500.delivery.model.FoodItem;
import edu.northeastern.cs5500.delivery.model.Model;
import edu.northeastern.cs5500.delivery.model.Order;
import java.util.ArrayList;
import java.util.Date;
import lombok.Data;
import org.bson.types.ObjectId;

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
    private ArrayList<FoodItem> cart = new ArrayList<>();
    private ArrayList<Payment> paymentMethods;
    private boolean loginStatus;

    // to sign up as a new user needs email, password, username
    //    public User(String email, String password, String userName) {
    //        this.email = email;
    //        this.password = password;
    //        this.userName = userName;
    //    }

}
