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
public final class DriverController_MembersInjector implements MembersInjector<DriverController> {
  private final Provider<OrderController> orderControllerProvider;

  public DriverController_MembersInjector(Provider<OrderController> orderControllerProvider) {
    this.orderControllerProvider = orderControllerProvider;
  }

  public static MembersInjector<DriverController> create(
      Provider<OrderController> orderControllerProvider) {
    return new DriverController_MembersInjector(orderControllerProvider);}

  @Override
  public void injectMembers(DriverController instance) {
    injectOrderController(instance, orderControllerProvider.get());
  }

  @InjectedFieldSignature("edu.northeastern.cs5500.delivery.controller.DriverController.orderController")
  public static void injectOrderController(DriverController instance,
      OrderController orderController) {
    instance.orderController = orderController;
  }
}
