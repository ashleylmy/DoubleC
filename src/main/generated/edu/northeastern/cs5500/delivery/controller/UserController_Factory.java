package edu.northeastern.cs5500.delivery.controller;

import dagger.internal.Factory;
import edu.northeastern.cs5500.delivery.model.user.User;
import edu.northeastern.cs5500.delivery.repository.GenericRepository;
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
public final class UserController_Factory implements Factory<UserController> {
  private final Provider<GenericRepository<User>> userRepositoryProvider;

  private final Provider<OrderController> orderControllerProvider;

  public UserController_Factory(Provider<GenericRepository<User>> userRepositoryProvider,
      Provider<OrderController> orderControllerProvider) {
    this.userRepositoryProvider = userRepositoryProvider;
    this.orderControllerProvider = orderControllerProvider;
  }

  @Override
  public UserController get() {
    UserController instance = newInstance(userRepositoryProvider.get());
    UserController_MembersInjector.injectOrderController(instance, orderControllerProvider.get());
    return instance;
  }

  public static UserController_Factory create(
      Provider<GenericRepository<User>> userRepositoryProvider,
      Provider<OrderController> orderControllerProvider) {
    return new UserController_Factory(userRepositoryProvider, orderControllerProvider);
  }

  public static UserController newInstance(GenericRepository<User> userRepository) {
    return new UserController(userRepository);
  }
}
