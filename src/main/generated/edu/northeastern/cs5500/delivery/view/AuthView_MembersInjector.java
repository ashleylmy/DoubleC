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
public final class AuthView_MembersInjector implements MembersInjector<AuthView> {
  private final Provider<JsonTransformer> jsonTransformerProvider;

  private final Provider<UserController> userControllerProvider;

  public AuthView_MembersInjector(Provider<JsonTransformer> jsonTransformerProvider,
      Provider<UserController> userControllerProvider) {
    this.jsonTransformerProvider = jsonTransformerProvider;
    this.userControllerProvider = userControllerProvider;
  }

  public static MembersInjector<AuthView> create(Provider<JsonTransformer> jsonTransformerProvider,
      Provider<UserController> userControllerProvider) {
    return new AuthView_MembersInjector(jsonTransformerProvider, userControllerProvider);}

  @Override
  public void injectMembers(AuthView instance) {
    injectJsonTransformer(instance, jsonTransformerProvider.get());
    injectUserController(instance, userControllerProvider.get());
  }

  @InjectedFieldSignature("edu.northeastern.cs5500.delivery.view.AuthView.jsonTransformer")
  public static void injectJsonTransformer(AuthView instance, JsonTransformer jsonTransformer) {
    instance.jsonTransformer = jsonTransformer;
  }

  @InjectedFieldSignature("edu.northeastern.cs5500.delivery.view.AuthView.userController")
  public static void injectUserController(AuthView instance, UserController userController) {
    instance.userController = userController;
  }
}
