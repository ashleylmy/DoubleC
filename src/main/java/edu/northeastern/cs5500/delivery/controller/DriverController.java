package edu.northeastern.cs5500.delivery.controller;



import edu.northeastern.cs5500.delivery.model.Driver.Car;
import edu.northeastern.cs5500.delivery.model.Driver.Driver;
import edu.northeastern.cs5500.delivery.model.Order;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


@Singleton
@Slf4j

public class DriverController {

    private final Driver driver;
    private final OrderController orderController;

    public DriverController(Driver driver, OrderController orderController, OrderController orderController1) {
        this.driver = driver;
        this.orderController = orderController;

    }

    @Inject


    public void orderPickup (Order order) {

        Car car = new Car("Toyota", "Camry", "BCN3300");
        Driver driver = new Driver(ObjectId.get(), "Alex Jackson", "+1 (425)-333-4444", car,2000.00);
        System.out.println(driver);
        // change order status
        this.orderController.orderPicked(order);
        Runnable newRunnable = new Runnable() {
            @Override
            public void run() {
                orderDelivered(order);
            }
        };
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
        executorService.scheduleAtFixedRate(newRunnable, 0,5, TimeUnit.SECONDS);

    }



    public void orderDelivered(Order order) {

       this.orderController.oderDelivered(order);
        Runnable newRunnable = new Runnable() {
            @Override
            public void run() {
                completeOrder(order);
            }
        };
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
        executorService.scheduleAtFixedRate(newRunnable, 0,5, TimeUnit.SECONDS);

    }





    public void completeOrder(Order order) {
        // notify user
        notifyUserComplete(order);
        System.out.println("Order" + order + "is completed.");

    }

    public void notifyUserComplete(Order order) {
        //User check status?
        System.out.println( "Your order" + order + "is completed.");
    }


}
