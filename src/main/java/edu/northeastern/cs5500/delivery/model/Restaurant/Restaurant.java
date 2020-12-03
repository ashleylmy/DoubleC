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
    private String category;
    private ArrayList<FoodItem> Menu;
    private LocalDate businessHours;
    private ArrayList<Order> orderHistory;
    private Double rating;

    public Restaurant(String name) {
        this.name = name;
    }

    //    public Double getRating() {
    //        int orderHasRating = 0;
    //        Double totalRating = 0.0;
    //        for (Order existingOrder : this.getOrderHistory()) {
    //            if (existingOrder.getRating() > 0) {
    //                orderHasRating += 1;
    //                totalRating += existingOrder.getRating();
    //            }
    //        }
    //        return totalRating / orderHasRating;
    //    }

    @Override
    public ObjectId getId() {
        return null;
    }

    @Override
    public void setId(ObjectId id) {}
}
