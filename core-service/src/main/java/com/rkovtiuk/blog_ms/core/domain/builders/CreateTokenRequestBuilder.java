package com.rkovtiuk.blog_ms.core.domain.builders;

import com.rkovtiuk.blog_ms.core.domain.entities.User;
import com.rkovtiuk.blog_ms.core.domain.requests.auth.CreateTokenRequest;

public class CreateTokenRequestBuilder {

    private CreateTokenRequest request;
    private User user;

    public CreateTokenRequestBuilder() {
        request = new CreateTokenRequest();
    }

    public CreateTokenRequestBuilder setUserId(Integer id){
        user.setId(id);
        return this;
    }

    public CreateTokenRequest build() {
        request.setUser(user);
        return request;
    }
}
