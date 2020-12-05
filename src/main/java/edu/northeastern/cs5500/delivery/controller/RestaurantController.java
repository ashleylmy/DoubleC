package edu.northeastern.cs5500.delivery.controller;

import edu.northeastern.cs5500.delivery.model.Order;
import edu.northeastern.cs5500.delivery.model.OrderStatus;
import edu.northeastern.cs5500.delivery.model.Restaurant.Restaurant;
import edu.northeastern.cs5500.delivery.repository.GenericRepository;
import java.util.Collection;
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

        final Restaurant restaurant1 = new Restaurant();
        final Restaurant restaurant2 = new Restaurant();

        try {
            addRestaurant(restaurant1);
            addRestaurant(restaurant2);
        } catch (Exception e) {
            log.error("RestaurantController > construct > adding default restuarants > failure?");
            e.printStackTrace();
        }
    }

    @Nonnull
    public Restaurant addRestaurant(Restaurant restaurant) throws Exception {
        log.debug("RestaurantController > addNewRestaurant(...)");
        ObjectId id = restaurant.getId();
        if (id != null && restaurants.get(id) != null) {
            // TODO exception
            throw new Exception("Restaurant existed");
        }
        return restaurants.add(restaurant);
    }

    @Nonnull
    public Collection<Restaurant> getAllRestaurants() {
        log.debug("RestaurantsController > getRestaurants()");
        return restaurants.getAll();
    }

    public Restaurant getRestaurant(ObjectId uuid) {
        log.debug("RestaurantController > getRestaurant({})", uuid);
        return restaurants.get(uuid);
    }

    // update one restaurant
    public void updateRestaurant(@Nonnull Restaurant restaurant) throws Exception {
        log.debug("RestaurantController > updateRestaurant");
        restaurants.update(restaurant);
    }

    public void deleteRestaurant(@Nonnull ObjectId id) throws Exception {
        log.debug("RestaurantController > deleteRestaurant");
        restaurants.delete(id);
    }

    // restaurant can cancel order if it's just placed.
    public void cancelOrder(Order order) {
        orderController.cancelOrder(order);
        log.debug("Restaurant has cancelled this order");
    }

    // restaurant will call this function once food is ready for pickup
    public void notifyDriver(Order order) {
        //        orderController.notifyDriver
        System.out.println("The order is ready for picked up!");
        order.setStatus(OrderStatus.READYFORPICKUP);
    }
}
