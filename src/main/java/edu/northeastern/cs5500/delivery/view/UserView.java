package edu.northeastern.cs5500.delivery.view;

import static spark.Spark.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.northeastern.cs5500.delivery.App;
import edu.northeastern.cs5500.delivery.JsonTransformer;
import edu.northeastern.cs5500.delivery.controller.UserController;
import edu.northeastern.cs5500.delivery.model.Order;
import edu.northeastern.cs5500.delivery.model.Restaurant.Restaurant;
import edu.northeastern.cs5500.delivery.model.user.User;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import spark.ModelAndView;
import spark.Session;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;

@Singleton
@Slf4j
public class UserView implements View {
    //    POST /signup - POST request to add an user.
    //    GET /user/:id - GET request to get user by :id.
    //    GET /user - GET request to get all the users.
    //    PUT /user/:id - UPDATE request to update an user by :id.
    //    DELETE /user/:id - DELETE request to delete an user by :id.

    @Inject
    UserView() {}

    @Inject JsonTransformer jsonTransformer;

    @Inject UserController userController;

    @Override
    public void register() {
        log.info("UserView > register");

        // TODO check what does logger do
        Logger logger = LoggerFactory.getLogger(App.class);

        // make user is logged in
        // user can review restaurants without logging in
//        before(
//                "/user",
//                (req, res) -> {
//                    Session session = req.session(true);
//                    boolean auth =
//                            session.attribute(Path.Web.AUTH_STATUS) != null
//                                    ? session.attribute(Path.Web.AUTH_STATUS)
//                                    : false;
//                    logger.info("auth status = " + auth);
//                    if (!auth) {
//                        logger.warn("Login is REQUIRED");
//                        res.redirect(Path.Web.GET_LOGIN_PAGE);
//                        halt(401);
//                    }
//                });

        // add new order, page will redirect to new order page
        get(
                "/checkout",
                (request, response) -> {
                    HashMap<String, Object> model = new HashMap<>();
                    User user=userController.getUserByEmail(request.session().attribute(Path.Web.ATTR_EMAIL));
                    Order order=userController.orderGen(user);
                    model.put("total", order.getTotalCost());
                    model.put("user", user);
                    model.put("cart", request.session().attribute("cart"));
                    return new ModelAndView(model, Path.Templates.CHECKOUT) {};
                },
                new HandlebarsTemplateEngine());

        // add new order, page will redirect to new order page
        post(
                Path.Web.CREATE_NEW_ORDER,
                (request, response) -> {
                    final String paramId = request.params(":id");
                    log.debug("/user/:id<{}>", paramId);
                    final ObjectId id = new ObjectId(paramId);
                    User user = userController.getUser(id);
                    double tip = Double.parseDouble(request.params("tip")); // add tip
                    Order order = userController.orderGen(user);
                    response.redirect(String.format("/order/{}", order.getId().toHexString()), 301);
                    return order;
                });

        // view all orders
        get(
                Path.Web.GET_ORDER_HISTORY,
                (request, response) -> {
                    return new ModelAndView(null, Path.Templates.ORDER_HISTORY) {};
                },
                new HandlebarsTemplateEngine());
        //                    final String paramId = request.params(":id");
        //                    log.debug("/user/:id<{}>", paramId);
        //                    final ObjectId id = new ObjectId(paramId);
        //                    User user = userController.getUser(id);
        //                    response.type("application/json");
        //                    return user.getOrderHistory();
        //                },
        //                jsonTransformer);

    }
}
