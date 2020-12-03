// package edu.northeastern.cs5500.delivery.repository;
//
// import dagger.Module;
// import dagger.Provides;
// import edu.northeastern.cs5500.delivery.model.Delivery;
// import edu.northeastern.cs5500.delivery.model.Order;
// import edu.northeastern.cs5500.delivery.model.user.User;
//
// @Module
// public class RepositoryModule {
//    @Provides
//    public GenericRepository<Delivery> provideDeliveryRepository() {
//        return new InMemoryRepository<>();
//    }
//
//    @Provides
//    public GenericRepository<User> provideUserRepository() {
//        return new InMemoryRepository<>();
//    }
//
//    @Provides
//    public GenericRepository<Order> provideOrderRepository() {
//        return new InMemoryRepository<>();
//    }
// }

/*
// Here's an example of how you imght swap out the in-memory repository for a database-backed
// repository:
*/

package edu.northeastern.cs5500.delivery.repository;

import dagger.Module;
import dagger.Provides;
import edu.northeastern.cs5500.delivery.model.*;
import edu.northeastern.cs5500.delivery.model.Driver.Driver;
import edu.northeastern.cs5500.delivery.model.Restaurant.Restaurant;
import edu.northeastern.cs5500.delivery.model.user.User;
import edu.northeastern.cs5500.delivery.service.MongoDBService;

@Module
public class RepositoryModule {
    @Provides
    public GenericRepository<Delivery> provideDeliveryRepository(MongoDBService mongoDBService) {
        return new MongoDBRepository<>(Delivery.class, mongoDBService);
    }

    @Provides
    public GenericRepository<User> provideUserRepository(MongoDBService mongoDBService) {
        return new MongoDBRepository<>(User.class, mongoDBService);
    }

    @Provides
    public GenericRepository<Order> provideOrderRepository(MongoDBService mongoDBService) {
        return new MongoDBRepository<>(Order.class, mongoDBService);
    }
    @Provides
    public GenericRepository<Restaurant> provideRestaurantRepository(MongoDBService mongoDBService) {
        return new MongoDBRepository<>(Restaurant.class, mongoDBService);
    }

    @Provides
    public GenericRepository<Driver> provideDriverRepository(MongoDBService mongoDBService) {
        return new MongoDBRepository<>(Driver.class, mongoDBService);
    }
}

