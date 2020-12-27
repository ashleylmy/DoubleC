package edu.northeastern.cs5500.delivery.view;

import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
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
public final class DeliveryView_MembersInjector implements MembersInjector<DeliveryView> {
  private final Provider<JsonTransformer> jsonTransformerProvider;

  private final Provider<DeliveryController> deliveryControllerProvider;

  public DeliveryView_MembersInjector(Provider<JsonTransformer> jsonTransformerProvider,
      Provider<DeliveryController> deliveryControllerProvider) {
    this.jsonTransformerProvider = jsonTransformerProvider;
    this.deliveryControllerProvider = deliveryControllerProvider;
  }

  public static MembersInjector<DeliveryView> create(
      Provider<JsonTransformer> jsonTransformerProvider,
      Provider<DeliveryController> deliveryControllerProvider) {
    return new DeliveryView_MembersInjector(jsonTransformerProvider, deliveryControllerProvider);}

  @Override
  public void injectMembers(DeliveryView instance) {
    injectJsonTransformer(instance, jsonTransformerProvider.get());
    injectDeliveryController(instance, deliveryControllerProvider.get());
  }

  @InjectedFieldSignature("edu.northeastern.cs5500.delivery.view.DeliveryView.jsonTransformer")
  public static void injectJsonTransformer(DeliveryView instance, JsonTransformer jsonTransformer) {
    instance.jsonTransformer = jsonTransformer;
  }

  @InjectedFieldSignature("edu.northeastern.cs5500.delivery.view.DeliveryView.deliveryController")
  public static void injectDeliveryController(DeliveryView instance,
      DeliveryController deliveryController) {
    instance.deliveryController = deliveryController;
  }
}
