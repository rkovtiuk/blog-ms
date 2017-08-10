package com.rkovtiuk.blog_ms.auth.service.impl;

import com.rkovtiuk.blog_ms.auth.domain.handlers.TokenHandler;
import com.rkovtiuk.blog_ms.auth.repository.AuthRepository;
import com.rkovtiuk.blog_ms.auth.service.AuthService;
import com.rkovtiuk.blog_ms.core.domain.requests.auth.CreateTokenRequest;
import com.rkovtiuk.blog_ms.core.utils.Constants;
import com.rkovtiuk.blog_ms.core.utils.Validator;
import com.rkovtiuk.blog_ms.db.domain.entities.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;

@Service
public class AuthServiceImpl implements AuthService {

    private final TokenHandler tokenHandler;
    private final AuthRepository repository;

    @Autowired
    public AuthServiceImpl(TokenHandler tokenHandler, AuthRepository repository) {
        this.tokenHandler = tokenHandler;
        this.repository = repository;
    }

    @Override
    public String createToken(CreateTokenRequest request) {
        String accessToken = tokenHandler.generateAccessToken(request.getUser().getId(), LocalDateTime.now());
        Token token = new Token();
        token.setCreatedAt(new Date().getTime());
        token.setSessionToken(accessToken);
        token.setUser(request.getUser());
        repository.save(token);
        return token.getSessionToken();
    }

    @Override
    public Integer getUserIdByToken(String token) {
        Token sessionToken = repository.findBySessionToken(token);
        if (sessionToken==null) return null;
        return sessionToken.getUser().getId();
    }

    @Override
    public Boolean isActiveSession(String token) {
        Token sessionToken = repository.findBySessionToken(token);
        if (sessionToken==null) return false;
        return Validator.isActiveToken(
                sessionToken.getCreatedAt(),
                new Date().getTime(),
                Constants.TOKEN_LIFETIME);
    }

    @Override
    public void removeToken(String token) {
        repository.removeBySessionToken(token);
    }
}
