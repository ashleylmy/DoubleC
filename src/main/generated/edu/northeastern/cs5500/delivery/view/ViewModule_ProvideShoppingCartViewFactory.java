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
public final class ViewModule_ProvideShoppingCartViewFactory implements Factory<View> {
  private final ViewModule module;

  private final Provider<ShoppingCartView> shoppingCartViewProvider;

  public ViewModule_ProvideShoppingCartViewFactory(ViewModule module,
      Provider<ShoppingCartView> shoppingCartViewProvider) {
    this.module = module;
    this.shoppingCartViewProvider = shoppingCartViewProvider;
  }

  @Override
  public View get() {
    return provideShoppingCartView(module, shoppingCartViewProvider.get());
  }

  public static ViewModule_ProvideShoppingCartViewFactory create(ViewModule module,
      Provider<ShoppingCartView> shoppingCartViewProvider) {
    return new ViewModule_ProvideShoppingCartViewFactory(module, shoppingCartViewProvider);
  }

  public static View provideShoppingCartView(ViewModule instance,
      ShoppingCartView shoppingCartView) {
    return Preconditions.checkNotNull(instance.provideShoppingCartView(shoppingCartView), "Cannot return null from a non-@Nullable @Provides method");
  }
}
