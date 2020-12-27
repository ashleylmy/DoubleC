package edu.northeastern.cs5500.delivery.controller;

import dagger.internal.Factory;
import edu.northeastern.cs5500.delivery.model.Order;
import edu.northeastern.cs5500.delivery.repository.GenericRepository;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class OrderController_Factory implements Factory<OrderController> {
  private final Provider<GenericRepository<Order>> ordersProvider;

  public OrderController_Factory(Provider<GenericRepository<Order>> ordersProvider) {
    this.ordersProvider = ordersProvider;
  }

  @Override
  public OrderController get() {
    return newInstance(ordersProvider.get());
  }

  public static OrderController_Factory create(Provider<GenericRepository<Order>> ordersProvider) {
    return new OrderController_Factory(ordersProvider);
  }

  public static OrderController newInstance(GenericRepository<Order> orders) {
    return new OrderController(orders);
  }
}
