package edu.northeastern.cs5500.delivery.controller;

import dagger.internal.Factory;
import edu.northeastern.cs5500.delivery.model.FoodItem;
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
public final class FoodItemController_Factory implements Factory<FoodItemController> {
  private final Provider<GenericRepository<FoodItem>> foodItemRepositoryProvider;

  private final Provider<OrderController> orderControllerProvider;

  public FoodItemController_Factory(
      Provider<GenericRepository<FoodItem>> foodItemRepositoryProvider,
      Provider<OrderController> orderControllerProvider) {
    this.foodItemRepositoryProvider = foodItemRepositoryProvider;
    this.orderControllerProvider = orderControllerProvider;
  }

  @Override
  public FoodItemController get() {
    FoodItemController instance = newInstance(foodItemRepositoryProvider.get());
    FoodItemController_MembersInjector.injectOrderController(instance, orderControllerProvider.get());
    return instance;
  }

  public static FoodItemController_Factory create(
      Provider<GenericRepository<FoodItem>> foodItemRepositoryProvider,
      Provider<OrderController> orderControllerProvider) {
    return new FoodItemController_Factory(foodItemRepositoryProvider, orderControllerProvider);
  }

  public static FoodItemController newInstance(GenericRepository<FoodItem> foodItemRepository) {
    return new FoodItemController(foodItemRepository);
  }
}
