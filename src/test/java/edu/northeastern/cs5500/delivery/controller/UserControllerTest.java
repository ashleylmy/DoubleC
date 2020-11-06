package edu.northeastern.cs5500.delivery.controller;

import edu.northeastern.cs5500.delivery.model.user.User;
import org.junit.jupiter.api.Test;

class UserControllerTest {
    // default user for testing.
    // TODO need to add order and shopping cart for testing

    final User defaultUser1 = new User("tstark@mail.com", "iron man", "Tony Stark");
    final User defaultUser2 = new User("pparker@mail.com", "spider man", "Peter Parker");

    @Test
    void getOrderHistory() {}

    @Test
    void checkout() {}

    @Test
    void checkOrderStatus() {}

    @Test
    void cancelOrder() {}

    @Test
    void reviewRestaurant() {}
}
