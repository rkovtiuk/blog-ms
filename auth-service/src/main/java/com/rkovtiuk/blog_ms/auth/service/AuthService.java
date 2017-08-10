package com.rkovtiuk.blog_ms.auth.service;

import com.rkovtiuk.blog_ms.core.domain.requests.auth.CreateTokenRequest;

public interface AuthService {
    Integer getUserIdByToken(String token);

    Boolean isActiveSession(String token);

    void removeToken(String token);

    String createToken(CreateTokenRequest request);
}
