package edu.northeastern.cs5500.delivery.controller;

import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
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
public final class RestaurantController_MembersInjector implements MembersInjector<RestaurantController> {
  private final Provider<DriverController> driverControllerProvider;

  private final Provider<OrderController> orderControllerProvider;

  public RestaurantController_MembersInjector(Provider<DriverController> driverControllerProvider,
      Provider<OrderController> orderControllerProvider) {
    this.driverControllerProvider = driverControllerProvider;
    this.orderControllerProvider = orderControllerProvider;
  }

  public static MembersInjector<RestaurantController> create(
      Provider<DriverController> driverControllerProvider,
      Provider<OrderController> orderControllerProvider) {
    return new RestaurantController_MembersInjector(driverControllerProvider, orderControllerProvider);}

  @Override
  public void injectMembers(RestaurantController instance) {
    injectDriverController(instance, driverControllerProvider.get());
    injectOrderController(instance, orderControllerProvider.get());
  }

  @InjectedFieldSignature("edu.northeastern.cs5500.delivery.controller.RestaurantController.driverController")
  public static void injectDriverController(RestaurantController instance,
      DriverController driverController) {
    instance.driverController = driverController;
  }

  @InjectedFieldSignature("edu.northeastern.cs5500.delivery.controller.RestaurantController.orderController")
  public static void injectOrderController(RestaurantController instance,
      OrderController orderController) {
    instance.orderController = orderController;
  }
}
