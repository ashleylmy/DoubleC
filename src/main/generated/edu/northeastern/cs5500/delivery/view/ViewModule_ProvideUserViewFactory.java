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
public final class ViewModule_ProvideUserViewFactory implements Factory<View> {
  private final ViewModule module;

  private final Provider<UserView> userViewProvider;

  public ViewModule_ProvideUserViewFactory(ViewModule module, Provider<UserView> userViewProvider) {
    this.module = module;
    this.userViewProvider = userViewProvider;
  }

  @Override
  public View get() {
    return provideUserView(module, userViewProvider.get());
  }

  public static ViewModule_ProvideUserViewFactory create(ViewModule module,
      Provider<UserView> userViewProvider) {
    return new ViewModule_ProvideUserViewFactory(module, userViewProvider);
  }

  public static View provideUserView(ViewModule instance, UserView userView) {
    return Preconditions.checkNotNull(instance.provideUserView(userView), "Cannot return null from a non-@Nullable @Provides method");
  }
}
