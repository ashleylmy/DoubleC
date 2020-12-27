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

    // update order in database
    public Order updateOrder(Order order) {
        return orders.update(order);
    }

    public Order orderReady(Order order) {
        order.setStatus(OrderStatus.READYFORPICKUP);
        return orders.update(order);
    }
    // both user and restaurant can cancel order. But user can only cancel unprepared order.
    public Order cancelOrder(Order order) {
            System.out.println("This order is cancelled! ");
            order.setStatus(OrderStatus.CANCELLED);
            return orders.update(order);
    }

    // driver will call this function once pick up the order to set order status to be PICKED
    public Order orderPicked(Order order) {
        order.setStatus(OrderStatus.PICKED);
        return orders.update(order);
    }

    // driver will call this function once order is delivered.
    // add current order to restaurant's and user's order history
    public Order orderDelivered(Order order) {
        order.setStatus(OrderStatus.DELIVERED);
        return orders.update(order);
    }

    //order completed
    public Order orderCompleted(Order order) {
        order.setStatus(OrderStatus.COMPLETED);
        return orders.update(order);
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
