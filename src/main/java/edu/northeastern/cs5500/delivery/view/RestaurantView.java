package edu.northeastern.cs5500.delivery.view;

import static spark.Spark.*;

import edu.northeastern.cs5500.delivery.JsonTransformer;
import edu.northeastern.cs5500.delivery.controller.RestaurantController;
import edu.northeastern.cs5500.delivery.model.Restaurant.Restaurant;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

@Singleton
@Slf4j
public class RestaurantView implements View {

    @Inject
    RestaurantView() {}

    @Inject JsonTransformer jsonTransformer;

    @Inject RestaurantController restaurantController;

    @Override
    public void register() {
        log.info("Restaurant View > register");

        // show all restaurants, thumbnails on main page
        get(
                Path.Web.HOME,
                (request, response) -> {
                    log.debug("home page");
                    return new ModelAndView(null, Path.Templates.INDEX) {};
                },
                new HandlebarsTemplateEngine());

        get(
                "/",
                (request, response) -> {
                    log.debug("/restaurants");
                    response.type("application/json");
                    return restaurantController.getAllRestaurants();
                },
                jsonTransformer);

        // got to a specific restaurant after user clicked from main page
        get(
                "/restaurants/:id",
                (request, response) -> {
                    final String paramId = request.params(":id");
                    log.debug("/restaurants/:id<{}>", paramId);
                    final ObjectId id = new ObjectId(paramId);
                    Restaurant restaurant = restaurantController.getRestaurant(id);
                    if (restaurant == null) {
                        halt(404);
                    }
                    response.type("application/json");
                    return restaurant;
                },
                jsonTransformer);

        // Not include CRUD for restaurants
        //        // add new restaurant
        //        // TODO not sure if this is necessary
        //        post(
        //                "/restaurants/addNew",
        //                (request, response) -> {
        //                    ObjectMapper mapper = new ObjectMapper();
        //                    Restaurant restaurant = mapper.readValue(request.body(),
        // Restaurant.class);
        //
        //                    // Ignore the user-provided ID if there is one
        //                    restaurant.setId(null);
        //                    restaurant = restaurantController.addRestaurant(restaurant);
        //
        //                    response.redirect(
        //                            String.format("/restaurants/{}",
        // restaurant.getId().toHexString()),
        //                            301);
        //                    return restaurant;
        //                });
        //
        //        // restaurant can be modified, new name, new menu etc
        //        // TODO check with TA about path, also the delete
        //        put(
        //                "/restaurants/:id",
        //                (request, response) -> {
        //                    ObjectMapper mapper = new ObjectMapper();
        //                    Restaurant restaurant = mapper.readValue(request.body(),
        // Restaurant.class);
        //
        //                    restaurantController.updateRestaurant(restaurant);
        //                    return restaurant;
        //                });
        //
        //        delete(
        //                "/restuarants",
        //                (request, response) -> {
        //                    ObjectMapper mapper = new ObjectMapper();
        //                    Restaurant restaurant = mapper.readValue(request.body(),
        // Restaurant.class);
        //
        //                    restaurantController.deleteRestaurant(restaurant.getId());
        //                    return restaurant;
        //                });
    }
}
