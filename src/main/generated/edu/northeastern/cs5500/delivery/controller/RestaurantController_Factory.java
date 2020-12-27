package edu.northeastern.cs5500.delivery.controller;

import dagger.internal.Factory;
import edu.northeastern.cs5500.delivery.model.Restaurant.Restaurant;
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
public final class RestaurantController_Factory implements Factory<RestaurantController> {
  private final Provider<GenericRepository<Restaurant>> restaurantsProvider;

  private final Provider<DriverController> driverControllerProvider;

  private final Provider<OrderController> orderControllerProvider;

  public RestaurantController_Factory(Provider<GenericRepository<Restaurant>> restaurantsProvider,
      Provider<DriverController> driverControllerProvider,
      Provider<OrderController> orderControllerProvider) {
    this.restaurantsProvider = restaurantsProvider;
    this.driverControllerProvider = driverControllerProvider;
    this.orderControllerProvider = orderControllerProvider;
  }

  @Override
  public RestaurantController get() {
    RestaurantController instance = newInstance(restaurantsProvider.get());
    RestaurantController_MembersInjector.injectDriverController(instance, driverControllerProvider.get());
    RestaurantController_MembersInjector.injectOrderController(instance, orderControllerProvider.get());
    return instance;
  }

  public static RestaurantController_Factory create(
      Provider<GenericRepository<Restaurant>> restaurantsProvider,
      Provider<DriverController> driverControllerProvider,
      Provider<OrderController> orderControllerProvider) {
    return new RestaurantController_Factory(restaurantsProvider, driverControllerProvider, orderControllerProvider);
  }

  public static RestaurantController newInstance(GenericRepository<Restaurant> restaurants) {
    return new RestaurantController(restaurants);
  }
}
