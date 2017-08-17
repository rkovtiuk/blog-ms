package com.rkovtiuk.blog_ms.core.domain.requests.auth;

import com.rkovtiuk.blog_ms.core.domain.requests.BaseRequest;

public class TokenRequest extends BaseRequest{

    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
