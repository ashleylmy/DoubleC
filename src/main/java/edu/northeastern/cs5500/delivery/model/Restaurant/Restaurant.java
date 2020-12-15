package edu.northeastern.cs5500.delivery.model.Restaurant;

import edu.northeastern.cs5500.delivery.model.FoodItem;
import edu.northeastern.cs5500.delivery.model.Model;
import edu.northeastern.cs5500.delivery.model.Order;
import java.time.LocalDate;
import java.util.ArrayList;
import lombok.Data;
import org.bson.types.ObjectId;

@Data
public class Restaurant implements Model {
    private ObjectId id;
    private String name;
    private String cuisine;
    private String image;
    private ArrayList<FoodItem> menu;
    private LocalDate businessHours;
    private ArrayList<Order> orderHistory;
    private Double rating;

}
