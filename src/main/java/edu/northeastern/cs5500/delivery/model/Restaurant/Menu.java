package edu.northeastern.cs5500.delivery.model.Restaurant;

import edu.northeastern.cs5500.delivery.model.Model;
import org.bson.types.ObjectId;

public class Menu implements Model {
    private String dishName;
    private Double price;

    public Menu(String dishName, Double price) {
        this.dishName = dishName;
        this.price = price;
    }

    @Override
    public ObjectId getId() {
        return null;
    }

    @Override
    public void setId(ObjectId id) {

    }
}