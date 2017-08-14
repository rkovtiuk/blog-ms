package com.rkovtiuk.blog_ms.core.utils;

import java.util.HashMap;
import java.util.Map;

import static com.rkovtiuk.blog_ms.core.utils.Path.AuthApi.TOKEN_HEADER_NAME;

public class NetworkUtils {

    public static Map<String, String> createTokenHeader(String token){
        Map<String, String> headers = new HashMap<>();
        headers.put(TOKEN_HEADER_NAME, token);
        return headers;
    }

}
