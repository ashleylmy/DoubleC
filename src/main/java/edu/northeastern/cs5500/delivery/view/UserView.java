package edu.northeastern.cs5500.delivery.view;

import static spark.Spark.*;

import edu.northeastern.cs5500.delivery.App;
import edu.northeastern.cs5500.delivery.JsonTransformer;
import edu.northeastern.cs5500.delivery.controller.UserController;
import edu.northeastern.cs5500.delivery.controller.OrderController;
import edu.northeastern.cs5500.delivery.model.Order;
import edu.northeastern.cs5500.delivery.model.user.Payment;
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

    @Inject
    UserView() {
    }

    @Inject
    JsonTransformer jsonTransformer;

    @Inject
    UserController userController;


    @Override
    public void register() {
        log.info("UserView > register");

        // TODO check what does logger do
        Logger logger = LoggerFactory.getLogger(App.class);

        // make user is logged in
        // user can review restaurants without logging in
        before(
                "/checkout",
                (req, res) -> {
                    Session session = req.session(true);
                    User user =
                            session.attribute(Path.Web.ATTR_EMAIL) != null
                                    ? userController.getUserByEmail(session.attribute(Path.Web.ATTR_EMAIL))
                                    : null;
                    if (user == null) {
                        logger.warn("Login is REQUIRED");
                        res.redirect(Path.Web.GET_LOGIN_PAGE);
                        halt(401);
                    }
                });

        // add new order, page will redirect to new order page
        get(
                "/checkout",
                (request, response) -> {
                    HashMap<String, Object> model = new HashMap<>();
                    User user = userController.getUserByEmail(request.session().attribute(Path.Web.ATTR_EMAIL));
                    model.put("total", String.format("%.2f", userController.totalCostOfCart(user)));
                    model.put("user", user);
                    model.put("cart", request.session().attribute("cart"));
                    model.put("userId", request.session().attribute(Path.Web.ATTR_USER_ID));
                    model.put("username", request.session().attribute(Path.Web.ATTR_USER_NAME));
                    model.put("email", request.session().attribute(Path.Web.ATTR_EMAIL));
                    log.info("checkout page"+ request.session().attribute("restaurant"));
                    return new ModelAndView(model, Path.Templates.CHECKOUT) {
                    };
                },
                new HandlebarsTemplateEngine());


        // add new order, page will redirect to new order page
        post("/checkout", ((request, response) -> {
            log.info("Post a checkout"+ request.session().attribute("restaurant"));
            User user = userController.getUserByEmail(request.session().attribute(Path.Web.ATTR_EMAIL));
            log.info(user.toString());
            String address = request.queryParams("address");
            String cardNumber = request.queryParams("cardNumber");
            String cardHolderName = request.queryParams("cardHolderName");
            request.session().attribute("cart", "");
            Payment payment = new Payment();
            payment.setCardHolderName(cardHolderName);
            payment.setCardNumber(cardNumber);
            user.setPaymentMethod(payment);
            user.setAddress(address);
            response.type("application/json");
            Order order = userController.orderGen(user, request.session().attribute("restaurant"));
            log.info(order.toString());
            request.session().attribute("restaurant", "");
            return order;
        }), jsonTransformer);


        // view all orders
        get(
                Path.Web.GET_ORDER_HISTORY,
                (request, response) -> {
                    final String paramId = request.params(":id");
                    log.info(paramId);
                    ObjectId id = new ObjectId(paramId);
                    User user = userController.getUser(id);
                    HashMap<String, Object> model = new HashMap<>();
                    model.put("userId", request.session().attribute(Path.Web.ATTR_USER_ID));
                    model.put("orders", userController.getAllOrders(user));
                    model.put("cart", request.session().attribute("cart"));
                    model.put("username", request.session().attribute(Path.Web.ATTR_USER_NAME));
                    model.put("email", request.session().attribute(Path.Web.ATTR_EMAIL));
                    model.put("id", paramId);
                    log.info(user.toString());
                    log.info(userController.getAllOrders(user).toString());
                    log.info(request.session().attribute("orders"));
                    return new ModelAndView(model, Path.Templates.ORDER_HISTORY) {
                    };
                },
                new HandlebarsTemplateEngine());


    }
}
