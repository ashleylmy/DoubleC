package edu.northeastern.cs5500.delivery.view;

import static spark.Spark.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.northeastern.cs5500.delivery.App;
import edu.northeastern.cs5500.delivery.JsonTransformer;
import edu.northeastern.cs5500.delivery.controller.UserController;
import edu.northeastern.cs5500.delivery.model.Order;
import edu.northeastern.cs5500.delivery.model.user.User;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import spark.Session;

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

        Logger logger = LoggerFactory.getLogger(App.class);

        // make user is logged in
        // user can review restaurants without logging in
        before(
                "/user",
                (req, res) -> {
                    Session session = req.session(true);
                    boolean auth =
                            session.attribute(Path.Web.AUTH_STATUS) != null
                                    ? session.attribute(Path.Web.AUTH_STATUS)
                                    : false;
                    logger.info("auth status = " + auth);
                    if (!auth) {
                        logger.warn("Login is REQUIRED");
                        res.redirect(Path.Web.GET_LOGIN_PAGE);
                        halt(401);
                    }
                });

        // get specific user
        get(
                "/user/:id",
                (request, response) -> {
                    final String paramId = request.params(":id");
                    log.debug("/user/:id<{}>", paramId);
                    final ObjectId id = new ObjectId(paramId);
                    User user = userController.getUser(id);
                    if (user == null) {
                        halt(404);
                    }
                    response.type("application/json");
                    return user;
                },
                jsonTransformer);

        // add new order
        post(
                "/user/:id/createOrder",
                (request, response) -> {
                    final String paramId = request.params(":id");
                    log.debug("/user/:id<{}>", paramId);
                    final ObjectId id = new ObjectId(paramId);
                    User user = userController.getUser(id);
                    double tip = Double.parseDouble(request.params("tip"));

                    Order order = userController.orderGen(user, tip);
                    response.redirect(String.format("/order/{}", order.getId().toHexString()), 301);
                    return user;
                });

        // view all orders
        get(
                "/user/:id/orderHistory",
                (request, response) -> {
                    final String paramId = request.params(":id");
                    log.debug("/user/:id<{}>", paramId);
                    final ObjectId id = new ObjectId(paramId);
                    User user = userController.getUser(id);
                    response.type("application/json");
                    return user.getOrderHistory();
                },
                jsonTransformer);

        // update user information
        put(
                "/user/:id",
                (request, response) -> {
                    ObjectMapper mapper = new ObjectMapper();
                    User user = mapper.readValue(request.body(), User.class);
                    userController.updateUser(user);
                    return user;
                });
    }
}
