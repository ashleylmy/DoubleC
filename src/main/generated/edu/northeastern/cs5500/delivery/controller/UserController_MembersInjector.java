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
public final class UserController_MembersInjector implements MembersInjector<UserController> {
  private final Provider<OrderController> orderControllerProvider;

  public UserController_MembersInjector(Provider<OrderController> orderControllerProvider) {
    this.orderControllerProvider = orderControllerProvider;
  }

  public static MembersInjector<UserController> create(
      Provider<OrderController> orderControllerProvider) {
    return new UserController_MembersInjector(orderControllerProvider);}

  @Override
  public void injectMembers(UserController instance) {
    injectOrderController(instance, orderControllerProvider.get());
  }

  @InjectedFieldSignature("edu.northeastern.cs5500.delivery.controller.UserController.orderController")
  public static void injectOrderController(UserController instance,
      OrderController orderController) {
    instance.orderController = orderController;
  }
}
