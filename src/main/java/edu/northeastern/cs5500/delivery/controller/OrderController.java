package edu.northeastern.cs5500.delivery.controller;

import edu.northeastern.cs5500.delivery.model.FoodItem;
import edu.northeastern.cs5500.delivery.model.Order;
import edu.northeastern.cs5500.delivery.model.OrderStatus;
import edu.northeastern.cs5500.delivery.repository.GenericRepository;
import java.util.ArrayList;
import javax.annotation.Nonnull;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;

@Singleton
@Slf4j
public class OrderController {
    private GenericRepository<Order> orders;

    // get order database
    @Inject
    OrderController(GenericRepository<Order> orders) {
        this.orders = orders;
    }
    // adding a new order to the orders database
    @Nonnull
    public Order addOrder(@Nonnull Order order) throws Exception {
        log.debug("OrderController > addOrder(...)");
        ObjectId id = order.getId();
        if (id != null && orders.get(id) != null) {
            // TODO exception
            throw new Exception("Order existed");
        }
        return orders.add(order);
    }

    // ** to do get order by order id */
    public Order getOrderById(ObjectId id) {
        return orders.get(id);
    }




    // both user and restaurant can cancel order. But user can only cancel unprepared order.
    public void cancelOrder(Order order) {
        if (order.getStatus().equals(OrderStatus.ORDERED)) {
            System.out.println("This order is cancelled! ");
            order.setStatus(OrderStatus.CANCELLED);
        } else {
            System.out.println("The oder has been prepared, can't cancel!");
        }
    }

    // driver will call this function once pick up the order to set order status to be PICKED
    public void orderPicked(Order order) {
        System.out.println("Your order is picked up! ");
        order.setStatus(OrderStatus.PICKED);
        System.out.println("Driver is delivering your order");
    }

    // driver will call this function once order is delivered.
    // add current order to restaurant's and user's order history
    public void oderDelivered(Order order) {
        System.out.println("Your order is delivered! ");
        order.setStatus(OrderStatus.DELIVERED);
    }

    // trigger once order status changed by user, either created or cancelled
    public void notifyRestaurant(Order order) {
        if (order.getStatus().equals(OrderStatus.ORDERED)) {
            System.out.println("The order has been placed!");
        }
        if (order.getStatus().equals(OrderStatus.CANCELLED)) {
            System.out.println("User just cancelled order.");
        }
    }

    // ** to do get order by order id */
    public Order getOrder(ObjectId id) {
        return orders.get(id);
    }
}
