package com.rkovtiuk.blog_ms.core.domain.requests.auth;

import com.rkovtiuk.blog_ms.core.domain.entities.User;
import com.rkovtiuk.blog_ms.core.domain.requests.BaseRequest;

public class CreateTokenRequest extends BaseRequest {

    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
