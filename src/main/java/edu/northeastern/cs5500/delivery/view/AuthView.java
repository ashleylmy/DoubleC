package edu.northeastern.cs5500.delivery.view;

import static spark.Spark.get;
import static spark.Spark.post;

import edu.northeastern.cs5500.delivery.JsonTransformer;
import edu.northeastern.cs5500.delivery.controller.UserController;
import edu.northeastern.cs5500.delivery.model.user.User;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.extern.slf4j.Slf4j;
import spark.ModelAndView;
import spark.Session;
import spark.template.handlebars.*;

@Singleton
@Slf4j
public class AuthView implements View {

    //    POST /signup - POST request to add an user.
    //    GET /user/:id - GET request to get user by :id.
    //    GET /user - GET request to get all the users.
    //    PUT /user/:id - UPDATE request to update an user by :id.
    //    DELETE /user/:id - DELETE request to delete an user by :id.

    @Inject
    AuthView() {}

    @Inject JsonTransformer jsonTransformer;

    @Inject UserController userController;

    @Override
    public void register() {
        log.info("AuthView > register");

        // user sign up
        get(
                Path.Web.GET_SIGN_UP,
                (req, res) -> {
                    return new ModelAndView(null, Path.Templates.SIGN_UP) {};
                },
                new HandlebarsTemplateEngine());

        // POST - Add an user to DB and redirect back to main page(restaurants page)
        // TODO check if user exist
        post(
                Path.Web.DO_SIGN_UP,
                (request, response) -> {
                    response.type(Path.Web.JSON_TYPE); // set our response type
                    String username = request.queryParams("username");
                    String email = request.queryParams("email");
                    String password = request.queryParams("password");
                    User user = new User(email, password, username);
                    userController.addUser(user);
                    response.status(201); // 201 Created
                    response.redirect("/", 301); // redirect to main page
                    return user;
                });

        // handle user Login

        get(
                Path.Web.GET_LOGIN_PAGE,
                (request, response) -> {
                    return new ModelAndView(null, Path.Templates.LOGIN);
                },
                new HandlebarsTemplateEngine());

        // TODO authentication
        post(
                Path.Web.DO_LOGIN,
                (request, response) -> {
                    String email=request.params("email");
                    if(email != null && !email.isEmpty()) {
                        //do something to check password
                        response.redirect("/", 301);
                        return "login successful";}
                    return "error";
                });

        // handle logout
        get(
                Path.Web.LOGOUT,
                (request, response) -> {
                    Session session = request.session(false);
                    if (session != null) session.invalidate();
                    response.redirect(Path.Web.HOME);
                    return response;
                });
    }
}
