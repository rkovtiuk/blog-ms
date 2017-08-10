package com.rkovtiuk.blog_ms.auth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TokenAuthService {

    @Autowired
    private TokenHandler tokenHandler;

    @Autowired
    private UserAuthService userAuthService;

//    public Optional<Authentication> getAuthentication(HttpServletRequest request){
//        return Optional
//                .ofNullable(request.getHeader(AUTH_HEADER_NAME))
//                .flatMap(tokenHandler::extractUserId)
//                .flatMap(userAuthService::findById)
//                .map(UserAuthentication::new);
//    }

}
