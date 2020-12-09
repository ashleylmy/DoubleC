package edu.northeastern.cs5500.delivery.view;

import dagger.internal.Factory;
import edu.northeastern.cs5500.delivery.JsonTransformer;
import edu.northeastern.cs5500.delivery.controller.DeliveryController;
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
public final class DeliveryView_Factory implements Factory<DeliveryView> {
  private final Provider<JsonTransformer> jsonTransformerProvider;

  private final Provider<DeliveryController> deliveryControllerProvider;

  public DeliveryView_Factory(Provider<JsonTransformer> jsonTransformerProvider,
      Provider<DeliveryController> deliveryControllerProvider) {
    this.jsonTransformerProvider = jsonTransformerProvider;
    this.deliveryControllerProvider = deliveryControllerProvider;
  }

  @Override
  public DeliveryView get() {
    DeliveryView instance = newInstance();
    DeliveryView_MembersInjector.injectJsonTransformer(instance, jsonTransformerProvider.get());
    DeliveryView_MembersInjector.injectDeliveryController(instance, deliveryControllerProvider.get());
    return instance;
  }

  public static DeliveryView_Factory create(Provider<JsonTransformer> jsonTransformerProvider,
      Provider<DeliveryController> deliveryControllerProvider) {
    return new DeliveryView_Factory(jsonTransformerProvider, deliveryControllerProvider);
  }

  public static DeliveryView newInstance() {
    return new DeliveryView();
  }
}
