package com.rkovtiuk.boot_microservices.userclientlibs.utils;

public final class Path {
    public static final String DOMAIN = "http://localhost/";

    public static final String DB_API = DOMAIN+"9000/";
    public static final String DB_API_GET_USER = DB_API+"user?id=";
    public static final String DB_API_CREATE_USER = DB_API+"user/add";


    public static final String SERVICE_API = DOMAIN+"9001/";
    public static final String NOTIFICATION_API = DOMAIN+"9002/";
    public static final String DASHBOARD_API = DOMAIN+"9001/";
}
