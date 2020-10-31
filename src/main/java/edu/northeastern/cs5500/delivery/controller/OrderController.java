package edu.northeastern.cs5500.delivery.controller;

import java.util.ArrayList;

import edu.northeastern.cs5500.delivery.model.Order;
import edu.northeastern.cs5500.delivery.model.OrderStatus;
import lombok.Data;

@Data
public class OrderController {
    private Order dishOrder;


    public OrderController(Order dishOrder) {
        this.dishOrder = dishOrder;
    }


    public Order generateOrder(ArrayList<Order.FoodItems> orders){
        Order newOrder = new Order();
        for(Order.FoodItems order: orders){
            newOrder.getDishOrder().add(order);
        }
        return newOrder;
    }

    public Double calculateCost(ArrayList<Order.FoodItems> orders){
        Double totalCost = 0.0;
        for(Order.FoodItems order: orders){
            totalCost += order.getPrice();}
        return totalCost;
    }

    public void cancelOrder(Order order){
        if (order.getStatus().equals(OrderStatus.ORDERED)){
            System.out.println("Your order is cancelled! ");
            order.setStatus(OrderStatus.CANCLLED);     
        } else{
            System.out.println("Your oder has been prepared, can't cancel!");
            }
        }


    public void orderPicked(Order order){
        if (order.getStatus().equals(OrderStatus.PICKED)){
            System.out.println("Your order is picked up! ");
            order.setStatus(OrderStatus.PICKED); 
        } else{
            System.out.println("Your oder has been prepared!");}
    }

    public void oderDelivered(Order order){        
        System.out.println("Your order is delivered! ");
        order.setStatus(OrderStatus.DELIVERED); 
    }
 

    public void notifyDriver(Order order){
        if(order.getStatus().equals(OrderStatus.READYFORPICKUP)){
            System.out.println("The order is ready for picked up!");
            order.setStatus(OrderStatus.READYFORPICKUP); 
        }
    }

    public void notifyRestaurant(Order order){
        if(order.getStatus().equals(OrderStatus.ORDERED)){
            System.out.println("The order has been placed!");
            order.setStatus(OrderStatus.ORDERED);  
        }
    }
}
