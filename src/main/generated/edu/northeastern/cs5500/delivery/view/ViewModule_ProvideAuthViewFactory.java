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
public final class ViewModule_ProvideAuthViewFactory implements Factory<View> {
  private final ViewModule module;

  private final Provider<AuthView> authViewProvider;

  public ViewModule_ProvideAuthViewFactory(ViewModule module, Provider<AuthView> authViewProvider) {
    this.module = module;
    this.authViewProvider = authViewProvider;
  }

  @Override
  public View get() {
    return provideAuthView(module, authViewProvider.get());
  }

  public static ViewModule_ProvideAuthViewFactory create(ViewModule module,
      Provider<AuthView> authViewProvider) {
    return new ViewModule_ProvideAuthViewFactory(module, authViewProvider);
  }

  public static View provideAuthView(ViewModule instance, AuthView authView) {
    return Preconditions.checkNotNull(instance.provideAuthView(authView), "Cannot return null from a non-@Nullable @Provides method");
  }
}
