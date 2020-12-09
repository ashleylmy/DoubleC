package edu.northeastern.cs5500.delivery.controller;

import edu.northeastern.cs5500.delivery.model.*;
import edu.northeastern.cs5500.delivery.model.user.Payment;
import edu.northeastern.cs5500.delivery.model.user.User;
import edu.northeastern.cs5500.delivery.repository.GenericRepository;
import java.util.Collection;
import javax.annotation.Nonnull;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;

@Singleton
@Slf4j
public class UserController {
    // collection of user User DB
    // all the users need to user the same user controller

    private final GenericRepository<User> users;

    @Inject OrderController orderController;

    @Inject
    UserController(GenericRepository<User> userRepository) {
        this.users = userRepository;
    }

    // adding a new user to the users database
    @Nonnull
    public User addUser(@Nonnull User user) throws Exception {
        log.debug("UserController > addUser(...)");
        ObjectId id = user.getId();
        if(existUser(user.getEmail())) throw new Exception("Email registered");
        if (id != null && users.get(id) != null ) {
            // TODO exception
            log.debug("UserController > addUser> ID existed");
            throw new Exception("UserID existed");
        }
        return users.add(user);
    }

    @Nonnull
    public Boolean existUser(String email) {
        Collection<User> dbUser = users.getAll();
        for (User user : dbUser) {
            if (user.getEmail().equals(email) ) return true;
        }
        return false;
    }

    @Nonnull
    public Boolean validUser(String email, String password) {
        Collection<User> dbUser = users.getAll();
        for (User user : dbUser) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) return true;
        }
        return false;
    }

    // -----------------------------------get user by uuid--------------------------------------//
    // use id to get specific user in the database
    public User getUser(@Nonnull ObjectId uuid) {
        return users.get(uuid);
    }

    // -----------------------------------modify shopping cart----------------------//
    // if the added new food belongs to different restaurant, shopping cart must be cleared before
    // adding
    // check if food is from the same restaurant
    // TODO check if user param can be used directly or needed to find user by getUser(uuid)

    private boolean validAdding(User user, FoodItem item) {
        if (user.getCart().isEmpty()) return true;
        String curSavedRestaurant = user.getCart().get(0).getRestaurant();
        return curSavedRestaurant.equals(item.getRestaurant());
    }

    // add item
    public void addItemToCart(User user, FoodItem item) {
        log.debug("UserController > adding item to shopping cart...");
        if (validAdding(user, item)) {
            user.getCart().add(item);
        } else {
            // pop up window ask user to choose if clear cart and then add item
            log.debug("the item belongs to different restaurant");
            System.out.println("Discard existing Items first");
        }
    }
    // delete item
    public void deleteItemFromCart(User user, FoodItem item) {
        user.getCart().remove(item);
    }

    // clear cart
    public void discardCurCart(User user) {
        user.getCart().clear();
    }

    // -------------------------checkout shopping cart------------------------//
    public void addNewPayment(User user, Payment newPayment) {
        user.getPaymentMethods().add(newPayment);
    }

    // add selected food to new order and set delivery address, payment info.
    public Order orderGen(User user, Double tip) throws Exception {
        // add shopping cart to order
        Order newOrder = orderController.generateOrder(user.getCart());
        newOrder.setUser(user);
        // adding tip to total cost
        newOrder.setTotalCost(newOrder.getTotalCost() + tip);
        // adding Payment method
        newOrder.setPaymentMethod(checkPayment(user));
        // adding delivery address
        newOrder.setDeliveryAddress(checkAddress(user));
        // setOrderStatus to ordered
        newOrder.setStatus(OrderStatus.ORDERED);
        // notify restaurant about new order
        orderController.addOrder(newOrder);
        orderController.notifyRestaurant(newOrder);
        return newOrder;
    }

    // check if valid payment is provided. If not, add new payment. Else return default(0) Payment
    private Payment checkPayment(User user) {
        log.debug("UserController > check User has valid Payment...");
        if (user.getPaymentMethods().isEmpty()) {
            System.out.println("Add new payment type");
            return new Payment();
        }
        return user.getPaymentMethods().get(0);
    }

    // check valid address
    private String checkAddress(User user) {
        log.debug("UserController > check User has valid address...");
        if (user.getAddress() == null) {
            System.out.println("Add new address type");
            return "new Address added";
        }
        return user.getAddress();
    }

    // ----------------------------Actions on incomplete Order-------------------------//
    // current orders
    @Nonnull
    public OrderStatus checkOrderStatus(Order order) {
        return order.getStatus();
    }

    public void cancelOrder(Order order) {
        orderController.cancelOrder(order);
        orderController.notifyRestaurant(order);
    }

    // ---------------------------Actions on Order History-------------------//
    // functions can be hidden for incomplete orders
    // also might be add review driver function
    public void reviewRestaurant(Order order, int rating) {
        if (order.getStatus().equals(OrderStatus.COMPLETED)) {
            order.setRating(rating);
        }
    }

    public void updateUser(User user) {
        log.debug("UserController > updateUser(...)");
        users.update(user);
    }
}
