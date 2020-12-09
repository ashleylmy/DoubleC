package edu.northeastern.cs5500.delivery.model;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.processing.Generated;

@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class ModelModule_ProvideDeliveryClassFactory implements Factory<Class<Delivery>> {
  private final ModelModule module;

  public ModelModule_ProvideDeliveryClassFactory(ModelModule module) {
    this.module = module;
  }

  @Override
  public Class<Delivery> get() {
    return provideDeliveryClass(module);
  }

  public static ModelModule_ProvideDeliveryClassFactory create(ModelModule module) {
    return new ModelModule_ProvideDeliveryClassFactory(module);
  }

  public static Class<Delivery> provideDeliveryClass(ModelModule instance) {
    return Preconditions.checkNotNull(instance.provideDeliveryClass(), "Cannot return null from a non-@Nullable @Provides method");
  }
}
