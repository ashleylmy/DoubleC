package edu.northeastern.cs5500.delivery.repository;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import edu.northeastern.cs5500.delivery.model.user.User;
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
public final class RepositoryModule_ProvideUserRepositoryFactory implements Factory<GenericRepository<User>> {
  private final RepositoryModule module;

  private final Provider<MongoDBService> mongoDBServiceProvider;

  public RepositoryModule_ProvideUserRepositoryFactory(RepositoryModule module,
      Provider<MongoDBService> mongoDBServiceProvider) {
    this.module = module;
    this.mongoDBServiceProvider = mongoDBServiceProvider;
  }

  @Override
  public GenericRepository<User> get() {
    return provideUserRepository(module, mongoDBServiceProvider.get());
  }

  public static RepositoryModule_ProvideUserRepositoryFactory create(RepositoryModule module,
      Provider<MongoDBService> mongoDBServiceProvider) {
    return new RepositoryModule_ProvideUserRepositoryFactory(module, mongoDBServiceProvider);
  }

  public static GenericRepository<User> provideUserRepository(RepositoryModule instance,
      MongoDBService mongoDBService) {
    return Preconditions.checkNotNull(instance.provideUserRepository(mongoDBService), "Cannot return null from a non-@Nullable @Provides method");
  }
}
