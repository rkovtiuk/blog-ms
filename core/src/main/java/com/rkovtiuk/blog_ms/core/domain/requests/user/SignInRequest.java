package com.rkovtiuk.blog_ms.core.domain.requests.user;

import com.rkovtiuk.blog_ms.core.domain.requests.BaseRequest;

public class SignInRequest extends BaseRequest{

    private String email;
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
