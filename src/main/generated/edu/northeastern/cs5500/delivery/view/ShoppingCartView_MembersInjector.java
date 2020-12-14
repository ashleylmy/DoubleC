package edu.northeastern.cs5500.delivery.view;

import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
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
public final class ShoppingCartView_MembersInjector implements MembersInjector<ShoppingCartView> {
  private final Provider<JsonTransformer> jsonTransformerProvider;

  private final Provider<UserController> userControllerProvider;

  public ShoppingCartView_MembersInjector(Provider<JsonTransformer> jsonTransformerProvider,
      Provider<UserController> userControllerProvider) {
    this.jsonTransformerProvider = jsonTransformerProvider;
    this.userControllerProvider = userControllerProvider;
  }

  public static MembersInjector<ShoppingCartView> create(
      Provider<JsonTransformer> jsonTransformerProvider,
      Provider<UserController> userControllerProvider) {
    return new ShoppingCartView_MembersInjector(jsonTransformerProvider, userControllerProvider);}

  @Override
  public void injectMembers(ShoppingCartView instance) {
    injectJsonTransformer(instance, jsonTransformerProvider.get());
    injectUserController(instance, userControllerProvider.get());
  }

  @InjectedFieldSignature("edu.northeastern.cs5500.delivery.view.ShoppingCartView.jsonTransformer")
  public static void injectJsonTransformer(ShoppingCartView instance,
      JsonTransformer jsonTransformer) {
    instance.jsonTransformer = jsonTransformer;
  }

  @InjectedFieldSignature("edu.northeastern.cs5500.delivery.view.ShoppingCartView.userController")
  public static void injectUserController(ShoppingCartView instance,
      UserController userController) {
    instance.userController = userController;
  }
}
