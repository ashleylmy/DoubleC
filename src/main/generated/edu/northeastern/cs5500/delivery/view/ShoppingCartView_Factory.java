package edu.northeastern.cs5500.delivery.view;

import dagger.internal.Factory;
import edu.northeastern.cs5500.delivery.JsonTransformer;
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
public final class ShoppingCartView_Factory implements Factory<ShoppingCartView> {
  private final Provider<JsonTransformer> jsonTransformerProvider;

  private final Provider<UserController> userControllerProvider;

  public ShoppingCartView_Factory(Provider<JsonTransformer> jsonTransformerProvider,
      Provider<UserController> userControllerProvider) {
    this.jsonTransformerProvider = jsonTransformerProvider;
    this.userControllerProvider = userControllerProvider;
  }

  @Override
  public ShoppingCartView get() {
    ShoppingCartView instance = newInstance();
    ShoppingCartView_MembersInjector.injectJsonTransformer(instance, jsonTransformerProvider.get());
    ShoppingCartView_MembersInjector.injectUserController(instance, userControllerProvider.get());
    return instance;
  }

  public static ShoppingCartView_Factory create(Provider<JsonTransformer> jsonTransformerProvider,
      Provider<UserController> userControllerProvider) {
    return new ShoppingCartView_Factory(jsonTransformerProvider, userControllerProvider);
  }

  public static ShoppingCartView newInstance() {
    return new ShoppingCartView();
  }
}
