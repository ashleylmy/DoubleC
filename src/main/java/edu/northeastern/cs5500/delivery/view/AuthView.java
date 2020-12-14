package edu.northeastern.cs5500.delivery.view;

import edu.northeastern.cs5500.delivery.JsonTransformer;
import edu.northeastern.cs5500.delivery.controller.UserController;
import edu.northeastern.cs5500.delivery.model.user.User;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.extern.slf4j.Slf4j;
import spark.ModelAndView;
import spark.Redirect;
import spark.Session;
import spark.template.handlebars.*;

import java.lang.reflect.ParameterizedType;

import static spark.Spark.*;

@Singleton
@Slf4j
public class AuthView implements View {

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
        post(
                Path.Web.DO_SIGN_UP,
                (request, response) -> {
                    String username = request.queryParams("username");
                    String email = request.queryParams("email");
                    String password = request.queryParams("password");
                    User user = new User();
                    user.setEmail(email);
                    user.setPassword(password);
                    user.setUserName(username);
                    userController.addUser(user);
                    Session session = request.session(true);
                    //TODO redirect doesn't work
                    response.redirect(Path.Web.HOME, 301);
                    return user;
                });

        // handle user Login
        get(
                Path.Web.GET_LOGIN_PAGE,
                (request, response) -> {
                    return new ModelAndView(null, Path.Templates.LOGIN);
                },
                new HandlebarsTemplateEngine());

        // check if email and password matches entry in database
        post(
                Path.Web.DO_LOGIN,
                (request, response) -> {
                    String email = request.queryParams("email");
                    String password = request.queryParams("password");
                    log.info(email+password);
                    if (email != null && !email.isEmpty()) {
                        // do something to check password
                        if (userController.validUser(email, password)) {
                            log.info("login successful");
                            //TODO redirect doesn't work
                            Session session = request.session(true);
                            User user=userController.existUser(email);
                            log.info(user.toString());
                            session.attribute(Path.Web.ATTR_USER_NAME, user.getUserName());
                            session.attribute(Path.Web.ATTR_USER_ID, user.getId().toString()); //saves the id as String
                            session.attribute(Path.Web.ATTR_EMAIL, user.getEmail());
                            response.redirect(Path.Web.HOME, 301);
                            return "login successful";
                        } else {
                            log.info("can't find email/password in database");
                            response.status(404);
                            return "can't find email/password in database";
                        }
                    }
                    response.status(404);
                    return "please enter valid email and password";
                });

        // handle logout
        // TODO not link for log out yet. Need to figure out navbar toggle
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
