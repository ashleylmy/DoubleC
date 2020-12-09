package edu.northeastern.cs5500.delivery.controller;

import dagger.internal.Factory;
import edu.northeastern.cs5500.delivery.model.Driver.Driver;
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
public final class DriverController_Factory implements Factory<DriverController> {
  private final Provider<GenericRepository<Driver>> driversProvider;

  private final Provider<OrderController> orderControllerProvider;

  public DriverController_Factory(Provider<GenericRepository<Driver>> driversProvider,
      Provider<OrderController> orderControllerProvider) {
    this.driversProvider = driversProvider;
    this.orderControllerProvider = orderControllerProvider;
  }

  @Override
  public DriverController get() {
    DriverController instance = newInstance(driversProvider.get());
    DriverController_MembersInjector.injectOrderController(instance, orderControllerProvider.get());
    return instance;
  }

  public static DriverController_Factory create(Provider<GenericRepository<Driver>> driversProvider,
      Provider<OrderController> orderControllerProvider) {
    return new DriverController_Factory(driversProvider, orderControllerProvider);
  }

  public static DriverController newInstance(GenericRepository<Driver> drivers) {
    return new DriverController(drivers);
  }
}
