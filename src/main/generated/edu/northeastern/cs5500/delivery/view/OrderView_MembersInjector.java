package edu.northeastern.cs5500.delivery.view;

import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import edu.northeastern.cs5500.delivery.JsonTransformer;
import edu.northeastern.cs5500.delivery.controller.OrderController;
import edu.northeastern.cs5500.delivery.controller.UserController;
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
public final class OrderView_MembersInjector implements MembersInjector<OrderView> {
  private final Provider<JsonTransformer> jsonTransformerProvider;

  private final Provider<OrderController> orderControllerProvider;

  private final Provider<UserController> userControllerProvider;

  public OrderView_MembersInjector(Provider<JsonTransformer> jsonTransformerProvider,
      Provider<OrderController> orderControllerProvider,
      Provider<UserController> userControllerProvider) {
    this.jsonTransformerProvider = jsonTransformerProvider;
    this.orderControllerProvider = orderControllerProvider;
    this.userControllerProvider = userControllerProvider;
  }

  public static MembersInjector<OrderView> create(Provider<JsonTransformer> jsonTransformerProvider,
      Provider<OrderController> orderControllerProvider,
      Provider<UserController> userControllerProvider) {
    return new OrderView_MembersInjector(jsonTransformerProvider, orderControllerProvider, userControllerProvider);}

  @Override
  public void injectMembers(OrderView instance) {
    injectJsonTransformer(instance, jsonTransformerProvider.get());
    injectOrderController(instance, orderControllerProvider.get());
    injectUserController(instance, userControllerProvider.get());
  }

  @InjectedFieldSignature("edu.northeastern.cs5500.delivery.view.OrderView.jsonTransformer")
  public static void injectJsonTransformer(OrderView instance, JsonTransformer jsonTransformer) {
    instance.jsonTransformer = jsonTransformer;
  }

  @InjectedFieldSignature("edu.northeastern.cs5500.delivery.view.OrderView.orderController")
  public static void injectOrderController(OrderView instance, OrderController orderController) {
    instance.orderController = orderController;
  }

  @InjectedFieldSignature("edu.northeastern.cs5500.delivery.view.OrderView.userController")
  public static void injectUserController(OrderView instance, UserController userController) {
    instance.userController = userController;
  }
}
