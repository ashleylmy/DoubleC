package edu.northeastern.cs5500.delivery.view;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
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
public final class ViewModule_ProvideDeliveryViewFactory implements Factory<View> {
  private final ViewModule module;

  private final Provider<DeliveryView> deliveryViewProvider;

  public ViewModule_ProvideDeliveryViewFactory(ViewModule module,
      Provider<DeliveryView> deliveryViewProvider) {
    this.module = module;
    this.deliveryViewProvider = deliveryViewProvider;
  }

  @Override
  public View get() {
    return provideDeliveryView(module, deliveryViewProvider.get());
  }

  public static ViewModule_ProvideDeliveryViewFactory create(ViewModule module,
      Provider<DeliveryView> deliveryViewProvider) {
    return new ViewModule_ProvideDeliveryViewFactory(module, deliveryViewProvider);
  }

  public static View provideDeliveryView(ViewModule instance, DeliveryView deliveryView) {
    return Preconditions.checkNotNull(instance.provideDeliveryView(deliveryView), "Cannot return null from a non-@Nullable @Provides method");
  }
}
