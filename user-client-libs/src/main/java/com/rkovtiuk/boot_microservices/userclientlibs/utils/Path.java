package com.rkovtiuk.boot_microservices.userclientlibs.utils;

public final class Path {
    private static final String DOMAIN = "http://localhost/";
    private static final String SERVICE_API = DOMAIN + "9001/";
    private static final String NOTIFICATION_API = DOMAIN+"9002/";
    private static final String DASHBOARD_API = DOMAIN+"9003/";

    public final class ServiceApi {
        public static final String GET_USER = SERVICE_API + "user?id=";
        public static final String CREATE_USER = SERVICE_API + "user/add";
    }

    public final class NotificationApi{
        public static final String GET_USER_NOTIFICATIONS = NOTIFICATION_API + "notifications?user_id=";
    }
}
