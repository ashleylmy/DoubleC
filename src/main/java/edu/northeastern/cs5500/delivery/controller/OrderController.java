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

    @Inject
    OrderController(GenericRepository<Order> orders) {
        this.orders = orders;
        log.debug("OrderController->constructor");
        if (orders.count() > 0) {
            return;
        }
        log.info("OrderController > construct > adding default order");

        final Order order1 = new Order();
        final Order order2 = new Order();

        try {
            addOrder(order1);
            addOrder(order2);
        } catch (Exception e) {
            log.error("OrderController > construct > adding default orders > failure?");
            e.printStackTrace();
        }
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

    // generate a partial order with food items and cost. User need to finish adding tip, address
    // and payment
    public Order generateOrder(ArrayList<FoodItem> foodItems) {
        Order newOrder = new Order();
        for (FoodItem item : foodItems) {
            newOrder.getDishOrder().add(item);
        }
        newOrder.setTotalCost(calculateSubtotal(foodItems));
        return newOrder;
    }

    // calculate the subtotal of an order.
    public Double calculateSubtotal(ArrayList<FoodItem> foodItems) {
        Double subtotal = 0.0;
        for (FoodItem item : foodItems) {
            subtotal += item.getPrice();
        }
        return subtotal;
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
        order.getRestaurant().getOrderHistory().add(order);
        order.getUser().getOrderHistory().add(order);
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

    //** to do get order by order id */

}
