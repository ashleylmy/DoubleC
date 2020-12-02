package edu.northeastern.cs5500.delivery.view;

import static spark.Spark.delete;
import static spark.Spark.get;
import static spark.Spark.post;
import static spark.Spark.put;

import javax.inject.Inject;
import javax.inject.Singleton;

import com.fasterxml.jackson.databind.ObjectMapper;

import edu.northeastern.cs5500.delivery.JsonTransformer;
import edu.northeastern.cs5500.delivery.controller.OrderController;
import edu.northeastern.cs5500.delivery.model.Order;
import lombok.extern.slf4j.Slf4j;
import spark.Response;
import spark.http.matching.Halt;

@Singleton
@Slf4j

public class OrderView implements View{

    @Inject
    OrderView(){}

    @Inject JsonTransformer jsonTransformer;

    @Inject OrderController orderController;

    @Override
    public void register() {
        log.info("OrderView > register");

        // get order information
        // ** base on order id to get order
        get(
            "/order/:id",
            (request, response) -> {
                final String paramId = request.params(":id");
                log.debug("/order/:id<{}>", paramId);
                Order order = order.getId();
                if (order == null){
                    halt(404, "Not existing");
                }
                response.type("application/json");
                return order;
            },
            jsonTransformer);

    

            
    // put order status (different order status: prepared, delivered)
    put("/order/cancel",
    (request, response)->{
        ObjectMapper mapper = new ObjectMapper();
        Order order= mapper.readValue(request.body(), Order.class);
        if (order.getId() == null) {
            response.status(400);
            return "";
        }

        orderController.cancelOrder(order);
        return order;
    });

    //put("picked")
    //
    put("/order/picked",
    (request, response)->{
        ObjectMapper mapper = new ObjectMapper();
        Order order= mapper.readValue(request.body(), Order.class);
        if (order.getId() == null) {
            response.status(400);
            return "";
        }

        orderController.orderPicked(order);
        return order;
    });

    //put("delivered")
    put("/order/dilivered",
    (request, response)->{
        ObjectMapper mapper = new ObjectMapper();
        Order order= mapper.readValue(request.body(), Order.class);
        if (order.getId() == null) {
            response.status(400);
            return "";
        }

        orderController.oderDelivered(order);
        return order;
    });
    
}
}

