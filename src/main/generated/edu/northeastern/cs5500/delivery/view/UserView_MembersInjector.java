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
public final class UserView_MembersInjector implements MembersInjector<UserView> {
  private final Provider<JsonTransformer> jsonTransformerProvider;

  private final Provider<UserController> userControllerProvider;

  public UserView_MembersInjector(Provider<JsonTransformer> jsonTransformerProvider,
      Provider<UserController> userControllerProvider) {
    this.jsonTransformerProvider = jsonTransformerProvider;
    this.userControllerProvider = userControllerProvider;
  }

  public static MembersInjector<UserView> create(Provider<JsonTransformer> jsonTransformerProvider,
      Provider<UserController> userControllerProvider) {
    return new UserView_MembersInjector(jsonTransformerProvider, userControllerProvider);}

  @Override
  public void injectMembers(UserView instance) {
    injectJsonTransformer(instance, jsonTransformerProvider.get());
    injectUserController(instance, userControllerProvider.get());
  }

  @InjectedFieldSignature("edu.northeastern.cs5500.delivery.view.UserView.jsonTransformer")
  public static void injectJsonTransformer(UserView instance, JsonTransformer jsonTransformer) {
    instance.jsonTransformer = jsonTransformer;
  }

  @InjectedFieldSignature("edu.northeastern.cs5500.delivery.view.UserView.userController")
  public static void injectUserController(UserView instance, UserController userController) {
    instance.userController = userController;
  }
}
