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
public final class AuthView_Factory implements Factory<AuthView> {
  private final Provider<JsonTransformer> jsonTransformerProvider;

  private final Provider<UserController> userControllerProvider;

  public AuthView_Factory(Provider<JsonTransformer> jsonTransformerProvider,
      Provider<UserController> userControllerProvider) {
    this.jsonTransformerProvider = jsonTransformerProvider;
    this.userControllerProvider = userControllerProvider;
  }

  @Override
  public AuthView get() {
    AuthView instance = newInstance();
    AuthView_MembersInjector.injectJsonTransformer(instance, jsonTransformerProvider.get());
    AuthView_MembersInjector.injectUserController(instance, userControllerProvider.get());
    return instance;
  }

  public static AuthView_Factory create(Provider<JsonTransformer> jsonTransformerProvider,
      Provider<UserController> userControllerProvider) {
    return new AuthView_Factory(jsonTransformerProvider, userControllerProvider);
  }

  public static AuthView newInstance() {
    return new AuthView();
  }
}
