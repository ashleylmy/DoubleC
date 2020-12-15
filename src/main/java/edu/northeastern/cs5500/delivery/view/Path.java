/** */
package edu.northeastern.cs5500.delivery.view;

/**
 * Cited Path class with modification
 *
 * <p>Origin @author Seun Matt Date 13 Oct 2016 Year 2016 (c) SMATT Corporation
 */
public class Path {

    /** Constructor cloud contacts */
    public Path() {}

    public static class Web {

        // this subclass holds the Web related static properties like routes
        // and others.
        // restaurants and home page would show same content

        public static String HOME = "/";
        public static String RESTAURANTS = "/restaurants";

        //		log in routes
        public static String GET_LOGIN_PAGE = "/signin";
        public static String DO_LOGIN = "/signin";
        public static String LOGOUT = "/signout";

        //		routes for performing crud on user
        public static String GET_SIGN_UP = "/signup"; // uses get method
        public static String DO_SIGN_UP = "/signup"; // uses post method
        public static String UPDATE =
                "/user/:id"; // uses put http method; data is contained in req body

        public static String GET_ORDER_HISTORY = "/user/:id/orderHistory";

        //		routes for managing users / authentication

        public static String NEW_USER = "/user"; // uses post method
        public static String UPDATE_CART = "/cart";

        public static String ATTR_USER_ID = "userId";
        public static String ATTR_USER_NAME = "username";
        public static String ATTR_EMAIL = "email";

        public static String OK_PATTERN = "[^a-zA-Z0-9:\",{}@_.\\- ]";
        public static int SESSION_TIMEOUT = 60 * 30; // 30 mins
        public static String JSON_TYPE = "application/json";
        public static String AUTH_STATUS = "AUTH_STATUS";

        // routes for managing orders
        public static String CREATE_NEW_ORDER = "/user/:id/createOrder";
    }

    public static class Templates {

        public static String MENU = "menu.hbs";
        public static String ORDER_DETAIL = "orderDetail.hbs";
        public static String INDEX = "index.hbs"; // main page with all restaurants
        public static String DASHBOARD = "main.hbs";
        public static String LOGIN = "signin.hbs"; // sign in page
        public static String SIGN_UP = "signup.hbs"; // sign up page
        public static String ORDER_HISTORY = "orderHistory.hbs"; // order history
        public static String CHECKOUT="checkout.hbs";
    }

    public static class Reply {

        public static int OK = 200;
        public static String OK_MSG = "Hurray! Operation Successful";
        public static int CONTACT_NOT_FOUND = 601;
        public static String CONTACT_NOT_FOUND_MSG =
                "Ooops! The resource is not found on the server";
    }
}
