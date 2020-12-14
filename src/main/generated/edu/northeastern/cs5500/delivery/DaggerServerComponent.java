package edu.northeastern.cs5500.delivery;

import com.google.common.collect.ImmutableSet;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import edu.northeastern.cs5500.delivery.controller.DeliveryController;
import edu.northeastern.cs5500.delivery.controller.DeliveryController_Factory;
import edu.northeastern.cs5500.delivery.controller.DriverController;
import edu.northeastern.cs5500.delivery.controller.DriverController_Factory;
import edu.northeastern.cs5500.delivery.controller.OrderController;
import edu.northeastern.cs5500.delivery.controller.OrderController_Factory;
import edu.northeastern.cs5500.delivery.controller.RestaurantController;
import edu.northeastern.cs5500.delivery.controller.RestaurantController_Factory;
import edu.northeastern.cs5500.delivery.controller.UserController;
import edu.northeastern.cs5500.delivery.controller.UserController_Factory;
import edu.northeastern.cs5500.delivery.model.Delivery;
import edu.northeastern.cs5500.delivery.model.Driver.Driver;
import edu.northeastern.cs5500.delivery.model.ModelModule;
import edu.northeastern.cs5500.delivery.model.Order;
import edu.northeastern.cs5500.delivery.model.Restaurant.Restaurant;
import edu.northeastern.cs5500.delivery.model.user.User;
import edu.northeastern.cs5500.delivery.repository.GenericRepository;
import edu.northeastern.cs5500.delivery.repository.RepositoryModule;
import edu.northeastern.cs5500.delivery.repository.RepositoryModule_ProvideDeliveryRepositoryFactory;
import edu.northeastern.cs5500.delivery.repository.RepositoryModule_ProvideDriverRepositoryFactory;
import edu.northeastern.cs5500.delivery.repository.RepositoryModule_ProvideOrderRepositoryFactory;
import edu.northeastern.cs5500.delivery.repository.RepositoryModule_ProvideRestaurantRepositoryFactory;
import edu.northeastern.cs5500.delivery.repository.RepositoryModule_ProvideUserRepositoryFactory;
import edu.northeastern.cs5500.delivery.service.MongoDBService;
import edu.northeastern.cs5500.delivery.service.MongoDBService_Factory;
import edu.northeastern.cs5500.delivery.view.AuthView;
import edu.northeastern.cs5500.delivery.view.AuthView_Factory;
import edu.northeastern.cs5500.delivery.view.DeliveryView;
import edu.northeastern.cs5500.delivery.view.DeliveryView_Factory;
import edu.northeastern.cs5500.delivery.view.OrderView;
import edu.northeastern.cs5500.delivery.view.OrderView_Factory;
import edu.northeastern.cs5500.delivery.view.RestaurantView;
import edu.northeastern.cs5500.delivery.view.RestaurantView_Factory;
import edu.northeastern.cs5500.delivery.view.ShoppingCartView;
import edu.northeastern.cs5500.delivery.view.ShoppingCartView_Factory;
import edu.northeastern.cs5500.delivery.view.StatusView;
import edu.northeastern.cs5500.delivery.view.StatusView_Factory;
import edu.northeastern.cs5500.delivery.view.UserView;
import edu.northeastern.cs5500.delivery.view.UserView_Factory;
import edu.northeastern.cs5500.delivery.view.View;
import edu.northeastern.cs5500.delivery.view.ViewModule;
import edu.northeastern.cs5500.delivery.view.ViewModule_ProvideAuthViewFactory;
import edu.northeastern.cs5500.delivery.view.ViewModule_ProvideDeliveryViewFactory;
import edu.northeastern.cs5500.delivery.view.ViewModule_ProvideOrderViewFactory;
import edu.northeastern.cs5500.delivery.view.ViewModule_ProvideRestaurantViewFactory;
import edu.northeastern.cs5500.delivery.view.ViewModule_ProvideShoppingCartViewFactory;
import edu.northeastern.cs5500.delivery.view.ViewModule_ProvideStatusViewFactory;
import edu.northeastern.cs5500.delivery.view.ViewModule_ProvideUserViewFactory;
import java.util.Set;
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
final class DaggerServerComponent implements ServerComponent {
  private final ViewModule viewModule;

  private Provider<MongoDBService> mongoDBServiceProvider;

  private Provider<GenericRepository<Delivery>> provideDeliveryRepositoryProvider;

  private Provider<DeliveryController> deliveryControllerProvider;

  private Provider<DeliveryView> deliveryViewProvider;

  private Provider<StatusView> statusViewProvider;

  private Provider<GenericRepository<User>> provideUserRepositoryProvider;

  private Provider<GenericRepository<Order>> provideOrderRepositoryProvider;

  private Provider<OrderController> orderControllerProvider;

  private Provider<UserController> userControllerProvider;

  private Provider<UserView> userViewProvider;

  private Provider<AuthView> authViewProvider;

  private Provider<GenericRepository<Restaurant>> provideRestaurantRepositoryProvider;

  private Provider<GenericRepository<Driver>> provideDriverRepositoryProvider;

  private Provider<DriverController> driverControllerProvider;

  private Provider<RestaurantController> restaurantControllerProvider;

  private Provider<RestaurantView> restaurantViewProvider;

  private Provider<ShoppingCartView> shoppingCartViewProvider;

  private Provider<OrderView> orderViewProvider;

  private DaggerServerComponent(ViewModule viewModuleParam,
      RepositoryModule repositoryModuleParam) {
    this.viewModule = viewModuleParam;
    initialize(viewModuleParam, repositoryModuleParam);
  }

  public static Builder builder() {
    return new Builder();
  }

  public static ServerComponent create() {
    return new Builder().build();
  }

  private View getProvideDeliveryView() {
    return ViewModule_ProvideDeliveryViewFactory.provideDeliveryView(viewModule, deliveryViewProvider.get());}

  private View getProvideStatusView() {
    return ViewModule_ProvideStatusViewFactory.provideStatusView(viewModule, statusViewProvider.get());}

  private View getProvideUserView() {
    return ViewModule_ProvideUserViewFactory.provideUserView(viewModule, userViewProvider.get());}

  private View getProvideAuthView() {
    return ViewModule_ProvideAuthViewFactory.provideAuthView(viewModule, authViewProvider.get());}

  private View getProvideRestaurantView() {
    return ViewModule_ProvideRestaurantViewFactory.provideRestaurantView(viewModule, restaurantViewProvider.get());}

  private View getProvideShoppingCartView() {
    return ViewModule_ProvideShoppingCartViewFactory.provideShoppingCartView(viewModule, shoppingCartViewProvider.get());}

  private View getProvideOrderView() {
    return ViewModule_ProvideOrderViewFactory.provideOrderView(viewModule, orderViewProvider.get());}

  private Set<View> getSetOfView() {
    return ImmutableSet.<View>of(getProvideDeliveryView(), getProvideStatusView(), getProvideUserView(), getProvideAuthView(), getProvideRestaurantView(), getProvideShoppingCartView(), getProvideOrderView());}

  @SuppressWarnings("unchecked")
  private void initialize(final ViewModule viewModuleParam,
      final RepositoryModule repositoryModuleParam) {
    this.mongoDBServiceProvider = DoubleCheck.provider(MongoDBService_Factory.create());
    this.provideDeliveryRepositoryProvider = RepositoryModule_ProvideDeliveryRepositoryFactory.create(repositoryModuleParam, mongoDBServiceProvider);
    this.deliveryControllerProvider = DoubleCheck.provider(DeliveryController_Factory.create(provideDeliveryRepositoryProvider));
    this.deliveryViewProvider = DoubleCheck.provider(DeliveryView_Factory.create(JsonTransformer_Factory.create(), deliveryControllerProvider));
    this.statusViewProvider = DoubleCheck.provider(StatusView_Factory.create());
    this.provideUserRepositoryProvider = RepositoryModule_ProvideUserRepositoryFactory.create(repositoryModuleParam, mongoDBServiceProvider);
    this.provideOrderRepositoryProvider = RepositoryModule_ProvideOrderRepositoryFactory.create(repositoryModuleParam, mongoDBServiceProvider);
    this.orderControllerProvider = DoubleCheck.provider(OrderController_Factory.create(provideOrderRepositoryProvider));
    this.userControllerProvider = DoubleCheck.provider(UserController_Factory.create(provideUserRepositoryProvider, orderControllerProvider));
    this.userViewProvider = DoubleCheck.provider(UserView_Factory.create(JsonTransformer_Factory.create(), userControllerProvider));
    this.authViewProvider = DoubleCheck.provider(AuthView_Factory.create(JsonTransformer_Factory.create(), userControllerProvider));
    this.provideRestaurantRepositoryProvider = RepositoryModule_ProvideRestaurantRepositoryFactory.create(repositoryModuleParam, mongoDBServiceProvider);
    this.provideDriverRepositoryProvider = RepositoryModule_ProvideDriverRepositoryFactory.create(repositoryModuleParam, mongoDBServiceProvider);
    this.driverControllerProvider = DoubleCheck.provider(DriverController_Factory.create(provideDriverRepositoryProvider, orderControllerProvider));
    this.restaurantControllerProvider = DoubleCheck.provider(RestaurantController_Factory.create(provideRestaurantRepositoryProvider, driverControllerProvider, orderControllerProvider));
    this.restaurantViewProvider = DoubleCheck.provider(RestaurantView_Factory.create(JsonTransformer_Factory.create(), restaurantControllerProvider));
    this.shoppingCartViewProvider = DoubleCheck.provider(ShoppingCartView_Factory.create(JsonTransformer_Factory.create(), userControllerProvider));
    this.orderViewProvider = DoubleCheck.provider(OrderView_Factory.create(JsonTransformer_Factory.create(), orderControllerProvider, userControllerProvider));
  }

  @Override
  public Server server() {
    return injectServer(Server_Factory.newInstance());}

  private Server injectServer(Server instance) {
    Server_MembersInjector.injectViews(instance, getSetOfView());
    return instance;
  }

  static final class Builder {
    private ViewModule viewModule;

    private RepositoryModule repositoryModule;

    private Builder() {
    }

    public Builder viewModule(ViewModule viewModule) {
      this.viewModule = Preconditions.checkNotNull(viewModule);
      return this;
    }

    /**
     * @deprecated This module is declared, but an instance is not used in the component. This method is a no-op. For more, see https://dagger.dev/unused-modules.
     */
    @Deprecated
    public Builder modelModule(ModelModule modelModule) {
      Preconditions.checkNotNull(modelModule);
      return this;
    }

    public Builder repositoryModule(RepositoryModule repositoryModule) {
      this.repositoryModule = Preconditions.checkNotNull(repositoryModule);
      return this;
    }

    public ServerComponent build() {
      if (viewModule == null) {
        this.viewModule = new ViewModule();
      }
      if (repositoryModule == null) {
        this.repositoryModule = new RepositoryModule();
      }
      return new DaggerServerComponent(viewModule, repositoryModule);
    }
  }
}
