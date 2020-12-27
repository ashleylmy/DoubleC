package edu.northeastern.cs5500.delivery.repository;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import edu.northeastern.cs5500.delivery.model.Delivery;
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
public final class RepositoryModule_ProvideDeliveryRepositoryFactory implements Factory<GenericRepository<Delivery>> {
  private final RepositoryModule module;

  private final Provider<MongoDBService> mongoDBServiceProvider;

  public RepositoryModule_ProvideDeliveryRepositoryFactory(RepositoryModule module,
      Provider<MongoDBService> mongoDBServiceProvider) {
    this.module = module;
    this.mongoDBServiceProvider = mongoDBServiceProvider;
  }

  @Override
  public GenericRepository<Delivery> get() {
    return provideDeliveryRepository(module, mongoDBServiceProvider.get());
  }

  public static RepositoryModule_ProvideDeliveryRepositoryFactory create(RepositoryModule module,
      Provider<MongoDBService> mongoDBServiceProvider) {
    return new RepositoryModule_ProvideDeliveryRepositoryFactory(module, mongoDBServiceProvider);
  }

  public static GenericRepository<Delivery> provideDeliveryRepository(RepositoryModule instance,
      MongoDBService mongoDBService) {
    return Preconditions.checkNotNull(instance.provideDeliveryRepository(mongoDBService), "Cannot return null from a non-@Nullable @Provides method");
  }
}
