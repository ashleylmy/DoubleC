package edu.northeastern.cs5500.delivery.controller;

import edu.northeastern.cs5500.delivery.model.Order;
import edu.northeastern.cs5500.delivery.model.OrderStatus;
import edu.northeastern.cs5500.delivery.model.Restaurant.Restaurant;
import edu.northeastern.cs5500.delivery.repository.GenericRepository;
import javax.annotation.Nonnull;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;

@Singleton
@Slf4j
// restaurant has tasks
// 1. cancel order 2. finish cooking order and notify driver 3. update restaurant rating
public class RestaurantController {
    private GenericRepository<Restaurant> restaurants;
    @Inject DriverController driverController;
    @Inject OrderController orderController;

    @Inject
    public RestaurantController(GenericRepository<Restaurant> restaurants) {
        this.restaurants = restaurants;
        log.debug("RestaurantController->constructor");
        if (restaurants.count() > 0) {
            return;
        }
        log.info("RestaurantController > construct > adding default restaurants with name");

        final Restaurant restaurant1 = new Restaurant("KFC");
        final Restaurant restaurant2 = new Restaurant("McDonald");

        try {
            addRestaurant(restaurant1);
            addRestaurant(restaurant2);
        } catch (Exception e) {
            log.error("RestaurantController > construct > adding default restuarants > failure?");
            e.printStackTrace();
        }
    }

    @Nonnull
    private Restaurant addRestaurant(Restaurant restaurant) throws Exception {
        log.debug("RestaurantController > addNewRestaurant(...)");
        ObjectId id = restaurant.getId();
        if (id != null && restaurants.get(id) != null) {
            // TODO exception
            throw new Exception("Order existed");
        }
        return restaurants.add(restaurant);
    }

    // restaurant can cancel order if it's just placed.
    public void cancelOrder(Order order) {
        orderController.cancelOrder(order);
        log.debug("Restaurant has cancelled this order");
    }

    // restaurant will call this function once food is ready for pickup
    public void notifyDriver(Order order) {
        System.out.println("The order is ready for picked up!");
        order.setStatus(OrderStatus.READYFORPICKUP);
    }
}
