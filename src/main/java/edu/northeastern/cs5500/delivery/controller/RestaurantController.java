package edu.northeastern.cs5500.delivery.controller;

import edu.northeastern.cs5500.delivery.model.Order;
import edu.northeastern.cs5500.delivery.model.Restaurant.Restaurant;
import lombok.extern.slf4j.Slf4j;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
@Slf4j


public class RestaurantController {
    private final Restaurant restaurant;
    private final DriverController driverController;
    private final OrderController orderController;


    @Inject
    public RestaurantController(Restaurant restaurant, DriverController driverController, OrderController orderController) {
        this.restaurant = restaurant;
        this.driverController = driverController;
        this.orderController = orderController;
    }


    public void cancelOrder(Order order) {
        this.orderController.cancelOrder(order);
    }


    public void notifyOrderCreated(Order order) {
        this.orderController.notifyRestaurant(order);
    }



    public void notifyDriver(Order order) {
        // notify driver to pick up
        this.driverController.orderPickup(order);


    }

    public void setRating() {

        System.out.println(this.restaurant.getRating());
    }

}
