package com.rkovtiuk.blog_ms.core.utils;

public final class Path {
    private static final String DOMAIN = "http://localhost/";
    private static final String USER_API = DOMAIN + "9001";
    private static final String NOTIFICATION_API = DOMAIN+"9002";
    private static final String DASHBOARD_API = DOMAIN+"9003";

    public final class UserApi {
        public static final String USER_PATH = "/user";
        public static final String GET_USER_DETAILS = USER_API + USER_PATH + "?id=";
        public static final String GET_USERS = USER_API + USER_PATH + "/all";
        public static final String PUT_USER = USER_API + USER_PATH + "/add";
    }

    public final class NotificationApi{
        public static final String GET_USER_NOTIFICATIONS = NOTIFICATION_API + "notifications?user_id=";
    }
}
