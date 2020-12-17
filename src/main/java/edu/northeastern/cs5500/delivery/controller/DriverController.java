package edu.northeastern.cs5500.delivery.controller;

import edu.northeastern.cs5500.delivery.model.Driver.Driver;
import edu.northeastern.cs5500.delivery.model.Order;
import edu.northeastern.cs5500.delivery.repository.GenericRepository;
import javax.annotation.Nonnull;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;

@Singleton
@Slf4j
public class DriverController {
    private GenericRepository<Driver> drivers;

    @Inject OrderController orderController;

    // driver has three main tasks: 1. pick an available driver from drivers DB 2. driver pickup
    // order 3. deliver order
    @Inject
    public DriverController(GenericRepository<Driver> drivers) {
        this.drivers = drivers;
        log.debug("DriverController->constructor");
        if (drivers.count() > 0) {
            return;
        }
        log.info("DriverController > construct > adding default driver with name");

        final Driver driver1 = new Driver("Alex Jackson");
        final Driver driver2 = new Driver("John Smith");

        try {
            addDriver(driver1);
            addDriver(driver2);
        } catch (Exception e) {
            log.error("DriverController > construct > adding default drivers > failure?");
            e.printStackTrace();
        }
    }

    // add new driver to drivers DB
    @Nonnull
    private Driver addDriver(Driver driver) throws Exception {
        log.debug("DriverController > addDriver(...)");
        ObjectId id = driver.getId();
        if (id != null && drivers.get(id) != null) {
            // TODO exception
            throw new Exception("DriverID existed");
        }
        return drivers.add(driver);
    }

    private Driver pickAvailableDriver() {
        return drivers.getAll().iterator().next();
    }

    // driver pick up an new order and change order status
    public void orderPickup(Order order) {
        log.debug("DriverController->orderPickup()" + "Calling orderController to pickup order");
        orderController.orderPicked(order);
        //        Runnable newRunnable = new Runnable() {
        //            @Override
        //            public void run() {
        //                orderDelivered(order);
        //            }
        //        };
        //        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
        //        executorService.scheduleAtFixedRate(newRunnable, 0,5, TimeUnit.SECONDS);

    }

    // Deliver order to User
    public void orderDelivered(Order order) {
        orderController.orderDelivered(order);
        //        Runnable newRunnable = new Runnable() {
        //            @Override
        //            public void run() {
        //                completeOrder(order);
        //            }
        //        };
        //        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
        //        executorService.scheduleAtFixedRate(newRunnable, 0,5, TimeUnit.SECONDS);

    }

    public void completeOrder(Driver order) {
        // notify user
        notifyUserComplete(order);
        System.out.println("Order" + order + "is completed.");
    }

    public void notifyUserComplete(Driver order) {
        // User check status?
        System.out.println("Your order" + order + "is completed.");
    }
}
