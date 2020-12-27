package edu.northeastern.cs5500.delivery.repository;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import edu.northeastern.cs5500.delivery.model.FoodItem;
import edu.northeastern.cs5500.delivery.service.MongoDBService;
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
public final class RepositoryModule_ProvideFoodItemRepositoryFactory implements Factory<GenericRepository<FoodItem>> {
  private final RepositoryModule module;

  private final Provider<MongoDBService> mongoDBServiceProvider;

  public RepositoryModule_ProvideFoodItemRepositoryFactory(RepositoryModule module,
      Provider<MongoDBService> mongoDBServiceProvider) {
    this.module = module;
    this.mongoDBServiceProvider = mongoDBServiceProvider;
  }

  @Override
  public GenericRepository<FoodItem> get() {
    return provideFoodItemRepository(module, mongoDBServiceProvider.get());
  }

  public static RepositoryModule_ProvideFoodItemRepositoryFactory create(RepositoryModule module,
      Provider<MongoDBService> mongoDBServiceProvider) {
    return new RepositoryModule_ProvideFoodItemRepositoryFactory(module, mongoDBServiceProvider);
  }

  public static GenericRepository<FoodItem> provideFoodItemRepository(RepositoryModule instance,
      MongoDBService mongoDBService) {
    return Preconditions.checkNotNull(instance.provideFoodItemRepository(mongoDBService), "Cannot return null from a non-@Nullable @Provides method");
  }
}
