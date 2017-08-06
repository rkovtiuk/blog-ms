package com.rkovtiuk.blog_ms.auth.service;

import com.rkovtiuk.blog_ms.auth.domain.UserAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

import static com.rkovtiuk.blog_ms.core.utils.Path.Params.AUTH_HEADER_NAME;

@Service
public class TokenAuthService {

    @Autowired
    private TokenHandler tokenHandler;

    @Autowired
    private UserAuthService userAuthService;

    public Optional<Authentication> getAuthentication(HttpServletRequest request){
        return Optional
                .ofNullable(request.getHeader(AUTH_HEADER_NAME))
                .flatMap(tokenHandler::extractUserId)
                .flatMap(userAuthService::findById)
                .map(UserAuthentication::new);
    }

}
