package edu.northeastern.cs5500.delivery.controller;

import dagger.internal.Factory;
import edu.northeastern.cs5500.delivery.model.Delivery;
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
public final class DeliveryController_Factory implements Factory<DeliveryController> {
  private final Provider<GenericRepository<Delivery>> deliveryRepositoryProvider;

  public DeliveryController_Factory(
      Provider<GenericRepository<Delivery>> deliveryRepositoryProvider) {
    this.deliveryRepositoryProvider = deliveryRepositoryProvider;
  }

  @Override
  public DeliveryController get() {
    return newInstance(deliveryRepositoryProvider.get());
  }

  public static DeliveryController_Factory create(
      Provider<GenericRepository<Delivery>> deliveryRepositoryProvider) {
    return new DeliveryController_Factory(deliveryRepositoryProvider);
  }

  public static DeliveryController newInstance(GenericRepository<Delivery> deliveryRepository) {
    return new DeliveryController(deliveryRepository);
  }
}
