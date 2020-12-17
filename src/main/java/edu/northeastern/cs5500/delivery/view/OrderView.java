package edu.northeastern.cs5500.delivery.view;

import static spark.Spark.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.northeastern.cs5500.delivery.JsonTransformer;
import edu.northeastern.cs5500.delivery.controller.OrderController;
import edu.northeastern.cs5500.delivery.controller.UserController;
import edu.northeastern.cs5500.delivery.model.Order;

import javax.inject.Inject;
import javax.inject.Singleton;

import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;

@Singleton
@Slf4j
public class OrderView implements View {

    @Inject
    OrderView() {
    }

    @Inject
    JsonTransformer jsonTransformer;

    @Inject
    OrderController orderController;
    @Inject
    UserController userController;

    @Override
    public void register() {
        log.info("OrderView > register");

        // get order information
        // ** base on order id to get order
        get(
                "/order/:id",
                (request, response) -> {
                    final String paramId = request.params(":id");
                    ObjectId id = new ObjectId(paramId);
                    Order order = orderController.getOrderById(id);
                    if (order == null) {
                        halt(404, "Not existing");
                    }
                    HashMap<String, Object> model = new HashMap<>();
                    model.put("userId", request.session().attribute(Path.Web.ATTR_USER_ID));
                    model.put("order", order);
                    model.put("cart", request.session().attribute("cart"));
                    model.put("username", request.session().attribute(Path.Web.ATTR_USER_NAME));
                    model.put("email", request.session().attribute(Path.Web.ATTR_EMAIL));
                    model.put("id", paramId);
                    return new ModelAndView(model, Path.Templates.ORDER_DETAIL) {
                    };
                },
                new HandlebarsTemplateEngine());

        // put order status (different order status: prepared, delivered)
        post(
                "/order/:id/cancel",
                (request, response) -> {
                    response.type("application/json");
                    final String paramId = request.params(":id");
                    ObjectId id = new ObjectId(paramId);
                    Order order = orderController.getOrderById(id);
                    orderController.cancelOrder(order);
                    if (order.getId() == null) {
                        response.status(400);
                        return "";
                    }
                    return order;
                }, jsonTransformer);

        // put("picked")
        //
        post(
                "/order/:id/picked",
                (request, response) -> {
                    response.type("application/json");
                    final String paramId = request.params(":id");
                    ObjectId id = new ObjectId(paramId);
                    Order order = orderController.getOrderById(id);
                    orderController.orderPicked(order);
                    return order;
                }, jsonTransformer);

        // put("delivered")
        post(
                "/order/:id/delivered",
                (request, response) -> {
                    response.type("application/json");
                    final String paramId = request.params(":id");
                    ObjectId id = new ObjectId(paramId);
                    Order order = orderController.getOrderById(id);
                    orderController.orderDelivered(order);
                    return order;
                }, jsonTransformer);

        post(
                "/order/:id/pickup",
                (request, response) -> {
                    response.type("application/json");
                    final String paramId = request.params(":id");
                    ObjectId id = new ObjectId(paramId);
                    Order order = orderController.getOrderById(id);
                    orderController.orderReady(order);
                    return order;
                }, jsonTransformer);

        post(
                "/order/:id/completed",
                (request, response) -> {
                    response.type("application/json");
                    final String paramId = request.params(":id");
                    ObjectId id = new ObjectId(paramId);
                    Order order = orderController.getOrderById(id);
                    orderController.orderCompleted(order);
                    return order;
                }, jsonTransformer);
    }
}
