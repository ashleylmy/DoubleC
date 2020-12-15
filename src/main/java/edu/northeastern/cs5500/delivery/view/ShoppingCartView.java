package edu.northeastern.cs5500.delivery.view;

import static spark.Spark.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.northeastern.cs5500.delivery.JsonTransformer;
import edu.northeastern.cs5500.delivery.controller.UserController;
import edu.northeastern.cs5500.delivery.model.FoodItem;
import edu.northeastern.cs5500.delivery.model.user.User;

import javax.inject.Inject;
import javax.inject.Singleton;

import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import spark.Session;
import spark.template.handlebars.*;

@Singleton
@Slf4j
public class ShoppingCartView implements View {

    @Inject
    ShoppingCartView() {
    }

    @Inject
    JsonTransformer jsonTransformer;

    @Inject
    UserController userController;

    @Override
    public void register() {
        log.info("ShoppingCart > register");

        post(
                "/add",
                (req, res) -> {
                    log.info("adding new item");
                   // FoodItem newItem = mapper.readValue(req.body(), FoodItem.class);
                    // String id=req.queryParams("")
                    String name = req.queryParams("name");
                    String price = req.queryParams("price");
                    String restaurant=req.queryParams("restaurant");
                    log.info(name+price+restaurant);
                    FoodItem newItem = new FoodItem();
                    newItem.setName(name);
                    newItem.setPrice(Double.valueOf(price));
                    newItem.setRestaurant(restaurant);
                    newItem.setQuantity(1);
                    log.info(newItem.toString());
                    Session session = req.session();
                    User currentUser = userController.getUserByEmail(session.attribute(Path.Web.ATTR_EMAIL));
                    userController.addItemToCart(currentUser, newItem);
                    session.attribute("cart", currentUser.getCart());
                    //res.redirect("/restaurants/:id", 301);
                    return "adding successful";
                });
    }
}
