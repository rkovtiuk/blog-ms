package com.rkovtiuk.blog_ms.core.utils;

public final class Path {
    private static final String DOMAIN = "http://localhost/";
    private static final String AUTH_API = DOMAIN + "8888";
    private static final String USER_API = DOMAIN + "9001";
    private static final String NOTIFICATION_API = DOMAIN+"9002";
    private static final String BLOG_API = DOMAIN+"9003";


    public final class AuthApi {
        public static final String TOKEN = "/token";
        public static final String CREATE_TOKEN = TOKEN + "/create";
        public static final String REMOVE_TOKEN = TOKEN + "/remove";
        public static final String ACTIVE_TOKEN = TOKEN + "/is_active";
        public static final String USER_ID_BY_TOKEN = TOKEN + "/get_user_id";
        public static final String TOKEN_HEADER_NAME = "X-Auth-Token";
    }

    public final class UserApi {
        public static final String SIGN_IN = "/sign_in";
        public static final String SIGN_UP = "/sign_up";
        public static final String USER_PATH = "/user";
        public static final String GET_USERS = "/users";
        public static final String GET_USER_DETAILS = USER_PATH;
        public static final String GET_USER_ID_BY_TOKEN = GET_USER_DETAILS + "/id";
    }

    public final class NotificationApi {
        public static final String GET_USER_NOTIFICATIONS = "/notifications";
    }

    public final class BlogApi {
        public static final String DASHBOARD = "/dashboard";
        public static final String GET_BLOGS_BY_AUTHOR = "/author/{id}/blogs";
        public static final String GET_BLOGS_BY_CATEGORY = "/blogs";
        public static final String REMOVE_BLOG = "/blogs/{id}/remove/";
        public static final String GET_BLOG_COMMENTS = "blogs/{id}/comments";
        public static final String CREATE_COMMENT = "blogs/{id}/comments";
    }
}
