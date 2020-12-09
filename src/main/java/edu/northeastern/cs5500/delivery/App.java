package edu.northeastern.cs5500.delivery;

import static spark.Spark.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App {

    // get the server port
    static int getAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 5000; // run on port 5000 by default
    }

    public static void main(String[] arg) {

        Logger logger = LoggerFactory.getLogger(App.class);
        externalStaticFileLocation("/var/www/public");
        // externalStaticFileLocation("src/main/resources/public");
        staticFileLocation("/public");

        // run on port 5000
        port(getAssignedPort());

        // Allow all cross-origin requests
        // Don't do this for real projects!
        options(
                "/*",
                (request, response) -> {
                    String accessControlRequestHeaders =
                            request.headers("Access-Control-Request-Headers");
                    if (accessControlRequestHeaders != null) {
                        response.header(
                                "Access-Control-Allow-Headers", accessControlRequestHeaders);
                    }

                    String accessControlRequestMethod =
                            request.headers("Access-Control-Request-Method");
                    if (accessControlRequestMethod != null) {
                        response.header("Access-Control-Allow-Methods", accessControlRequestMethod);
                    }

                    return "OK";
                });

        // make user is logged in
        // user can review restaurants without logging in
        //        before(
        //                "/*/",
        //                (req, res) -> {
        //                    Session session = req.session(true);
        //                    boolean auth =
        //                            session.attribute(Path.Web.AUTH_STATUS) != null
        //                                    ? session.attribute(Path.Web.AUTH_STATUS)
        //                                    : false;
        //                    logger.info("auth status = " + auth);
        //                    if (!auth) {
        //                        logger.warn("Secured Area! Login is REQUIRED");
        //                        res.redirect(Path.Web.GET_LOGIN_PAGE);
        //                        halt(401);
        //                    }
        //                });

        // print all unhandled exceptions
        exception(Exception.class, (e, req, res) -> e.printStackTrace());

        // load and start the server
        DaggerServerComponent.create().server().start();
    }
}
