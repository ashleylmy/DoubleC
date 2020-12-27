package edu.northeastern.cs5500.delivery.view;

import dagger.internal.Factory;
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
public final class OrderView_Factory implements Factory<OrderView> {
  private final Provider<JsonTransformer> jsonTransformerProvider;

  private final Provider<OrderController> orderControllerProvider;

  private final Provider<UserController> userControllerProvider;

  public OrderView_Factory(Provider<JsonTransformer> jsonTransformerProvider,
      Provider<OrderController> orderControllerProvider,
      Provider<UserController> userControllerProvider) {
    this.jsonTransformerProvider = jsonTransformerProvider;
    this.orderControllerProvider = orderControllerProvider;
    this.userControllerProvider = userControllerProvider;
  }

  @Override
  public OrderView get() {
    OrderView instance = newInstance();
    OrderView_MembersInjector.injectJsonTransformer(instance, jsonTransformerProvider.get());
    OrderView_MembersInjector.injectOrderController(instance, orderControllerProvider.get());
    OrderView_MembersInjector.injectUserController(instance, userControllerProvider.get());
    return instance;
  }

  public static OrderView_Factory create(Provider<JsonTransformer> jsonTransformerProvider,
      Provider<OrderController> orderControllerProvider,
      Provider<UserController> userControllerProvider) {
    return new OrderView_Factory(jsonTransformerProvider, orderControllerProvider, userControllerProvider);
  }

  public static OrderView newInstance() {
    return new OrderView();
  }
}
