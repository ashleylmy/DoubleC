package edu.northeastern.cs5500.delivery.controller;

import java.util.ArrayList;

import edu.northeastern.cs5500.delivery.model.FoodItem;
import edu.northeastern.cs5500.delivery.model.Order;
import edu.northeastern.cs5500.delivery.model.OrderStatus;
import lombok.extern.slf4j.Slf4j;

import javax.inject.Singleton;

@Singleton
@Slf4j
public class OrderController {
    private Order dishOrder;


    public OrderController(Order dishOrder) {
        this.dishOrder = dishOrder;
    }

    //generate a partial order with food items and cost. User need to finish adding tip, address and payment
    public Order generateOrder(ArrayList<FoodItem> foodItems){
        Order newOrder = new Order();
        for(FoodItem item: foodItems){
            newOrder.getDishOrder().add(item);
        }
        newOrder.setTotalCost(calculateSubtotal(foodItems));
        return newOrder;
    }

    //calculate the subtotal of an order.
    public Double calculateSubtotal(ArrayList<FoodItem> foodItems){
        Double subtotal = 0.0;
        for(FoodItem item: foodItems){
            subtotal += item.getPrice();}
        return subtotal;
    }

    //both user and restaurant can cancel order. But user can only cancel unprepared order.
    public void cancelOrder(Order order){
        if (order.getStatus().equals(OrderStatus.ORDERED)){
            System.out.println("This order is cancelled! ");
            order.setStatus(OrderStatus.CANCELLED);
        } else{
            System.out.println("Your oder has been prepared, can't cancel!");
            }
        }

        //driver will call this function once pick up the order to set order status to be PICKED
    public void orderPicked(Order order){
        System.out.println("Your order is picked up! ");
        order.setStatus(OrderStatus.PICKED);
        System.out.println("Driver is delivering your order");
    }

    //driver will call this function once order is delivered.
    public void oderDelivered(Order order){        
        System.out.println("Your order is delivered! ");
        order.setStatus(OrderStatus.DELIVERED); 
    }
 

    //restaurant will call this function once food is ready for pickup
    public void notifyDriver(Order order){
        System.out.println("The order is ready for picked up!");
        order.setStatus(OrderStatus.READYFORPICKUP);

    }

    public void notifyRestaurant(Order order){
        if(order.getStatus().equals(OrderStatus.ORDERED)){
            System.out.println("The order has been placed!");
        }if(order.getStatus().equals(OrderStatus.CANCELLED)){
            System.out.println("User just cancelled order.");
        }
    }
}
