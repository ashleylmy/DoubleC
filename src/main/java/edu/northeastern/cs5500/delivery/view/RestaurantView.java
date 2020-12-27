package edu.northeastern.cs5500.delivery.view;

import static spark.Spark.*;

import edu.northeastern.cs5500.delivery.JsonTransformer;
import edu.northeastern.cs5500.delivery.controller.RestaurantController;
import edu.northeastern.cs5500.delivery.model.Restaurant.Restaurant;
import java.util.HashMap;
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
                    HashMap<String, Object> model = new HashMap<>();
                    model.put("userId", request.session().attribute(Path.Web.ATTR_USER_ID));
                    model.put("restaurants", restaurantController.getAllRestaurants());
                    model.put("username", request.session().attribute(Path.Web.ATTR_USER_NAME));
                    model.put("email", request.session().attribute(Path.Web.ATTR_EMAIL));
                    model.put("cart", request.session().attribute("cart"));
                    request.session().attribute("restaurant", "");
                    log.info("home page >"+request.session().attributes().toString());
                    return new ModelAndView(model, Path.Templates.INDEX) {};
                },
                new HandlebarsTemplateEngine());

        get(
                "/restaurants",
                (request, response) -> {
                    log.debug("/restaurants");
                    response.redirect("/", 301);
                    return "show restaurants";
                });

        // got to a specific restaurant after user clicked from main page
        get(
                "/restaurants/:id",
                (request, response) -> {
                    final String paramId = request.params(":id");
                    final ObjectId id = new ObjectId(paramId);
                    Restaurant restaurant = restaurantController.getRestaurant(id);
                    request.session().attribute("restaurant", restaurant.getName());
                    HashMap<String, Object> model = new HashMap<>();
                    model.put("restaurant", restaurant);
                    model.put("userId", request.session().attribute(Path.Web.ATTR_USER_ID));
                    model.put("username", request.session().attribute(Path.Web.ATTR_USER_NAME));
                    model.put("email", request.session().attribute(Path.Web.ATTR_EMAIL));
                    model.put("cart", request.session().attribute("cart"));
                    log.info("restuarant page" + request.session().attribute("restaurant"));
                    return new ModelAndView(model, Path.Templates.MENU) {};
                },
                new HandlebarsTemplateEngine());
    }
}
