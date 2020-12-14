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
public final class FoodItemController_MembersInjector implements MembersInjector<FoodItemController> {
  private final Provider<OrderController> orderControllerProvider;

  public FoodItemController_MembersInjector(Provider<OrderController> orderControllerProvider) {
    this.orderControllerProvider = orderControllerProvider;
  }

  public static MembersInjector<FoodItemController> create(
      Provider<OrderController> orderControllerProvider) {
    return new FoodItemController_MembersInjector(orderControllerProvider);}

  @Override
  public void injectMembers(FoodItemController instance) {
    injectOrderController(instance, orderControllerProvider.get());
  }

  @InjectedFieldSignature("edu.northeastern.cs5500.delivery.controller.FoodItemController.orderController")
  public static void injectOrderController(FoodItemController instance,
      OrderController orderController) {
    instance.orderController = orderController;
  }
}
