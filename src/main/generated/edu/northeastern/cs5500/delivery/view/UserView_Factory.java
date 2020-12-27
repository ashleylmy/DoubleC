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
public final class UserView_Factory implements Factory<UserView> {
  private final Provider<JsonTransformer> jsonTransformerProvider;

  private final Provider<UserController> userControllerProvider;

  public UserView_Factory(Provider<JsonTransformer> jsonTransformerProvider,
      Provider<UserController> userControllerProvider) {
    this.jsonTransformerProvider = jsonTransformerProvider;
    this.userControllerProvider = userControllerProvider;
  }

  @Override
  public UserView get() {
    UserView instance = newInstance();
    UserView_MembersInjector.injectJsonTransformer(instance, jsonTransformerProvider.get());
    UserView_MembersInjector.injectUserController(instance, userControllerProvider.get());
    return instance;
  }

  public static UserView_Factory create(Provider<JsonTransformer> jsonTransformerProvider,
      Provider<UserController> userControllerProvider) {
    return new UserView_Factory(jsonTransformerProvider, userControllerProvider);
  }

  public static UserView newInstance() {
    return new UserView();
  }
}
