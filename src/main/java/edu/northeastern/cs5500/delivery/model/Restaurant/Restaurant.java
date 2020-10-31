package edu.northeastern.cs5500.delivery.model.Restaurant;

import edu.northeastern.cs5500.delivery.model.Model;
import org.bson.types.ObjectId;

import java.time.LocalDate;
import java.util.ArrayList;

public class Restaurant implements Model {


    private String category;
    private Menu Menu;
    private LocalDate businessHour;
    private Rating rating;
    private ArrayList<String> menuList = new ArrayList<>();


    public Restaurant(String category, Menu menu, LocalDate businessHour, Rating rating, ArrayList<String> menuList) {
        this.category = category;
        this.Menu = menu;
        this.businessHour = businessHour;
        this.rating = rating;
        this.menuList = menuList;
    }

    public Rating getRating() {
        return this.rating;
    }

    @Override
    public ObjectId getId() {
        return null;
    }

    @Override
    public void setId(ObjectId id) {

    }
}