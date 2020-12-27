package edu.northeastern.cs5500.delivery.repository;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import edu.northeastern.cs5500.delivery.model.Order;
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
public final class RepositoryModule_ProvideOrderRepositoryFactory implements Factory<GenericRepository<Order>> {
  private final RepositoryModule module;

  private final Provider<MongoDBService> mongoDBServiceProvider;

  public RepositoryModule_ProvideOrderRepositoryFactory(RepositoryModule module,
      Provider<MongoDBService> mongoDBServiceProvider) {
    this.module = module;
    this.mongoDBServiceProvider = mongoDBServiceProvider;
  }

  @Override
  public GenericRepository<Order> get() {
    return provideOrderRepository(module, mongoDBServiceProvider.get());
  }

  public static RepositoryModule_ProvideOrderRepositoryFactory create(RepositoryModule module,
      Provider<MongoDBService> mongoDBServiceProvider) {
    return new RepositoryModule_ProvideOrderRepositoryFactory(module, mongoDBServiceProvider);
  }

  public static GenericRepository<Order> provideOrderRepository(RepositoryModule instance,
      MongoDBService mongoDBService) {
    return Preconditions.checkNotNull(instance.provideOrderRepository(mongoDBService), "Cannot return null from a non-@Nullable @Provides method");
  }
}
