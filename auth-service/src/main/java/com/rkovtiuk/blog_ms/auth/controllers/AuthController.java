package com.rkovtiuk.blog_ms.auth.controllers;

import com.rkovtiuk.blog_ms.auth.service.AuthService;
import com.rkovtiuk.blog_ms.core.domain.requests.auth.CreateTokenRequest;
import com.rkovtiuk.blog_ms.core.domain.requests.auth.TokenRequest;
import com.rkovtiuk.blog_ms.core.exception.EmptyRequestException;
import com.rkovtiuk.blog_ms.core.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

import static com.rkovtiuk.blog_ms.core.utils.Path.AuthApi.*;
import static com.rkovtiuk.blog_ms.core.utils.Validator.isEmpty;
import static com.rkovtiuk.blog_ms.core.utils.Validator.isObjectEmpty;

@RestController
public class AuthController {

    private final AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @RequestMapping(value = CREATE_TOKEN, method = RequestMethod.POST)
    public @ResponseBody String createToken(@RequestBody CreateTokenRequest request){
        return authService.createToken(request);
    }

    @RequestMapping(value = USER_ID_BY_TOKEN, method = RequestMethod.POST)
    public @ResponseBody Integer getUserId(@RequestHeader(name = TOKEN_HEADER_NAME) String token) throws EmptyRequestException, NotFoundException {
        if (isEmpty(token)) throw new EmptyRequestException();
        return Optional.of(authService.getUserIdByToken(token)).orElseThrow(NotFoundException::new);
    }

    @RequestMapping(value = ACTIVE_TOKEN, method = RequestMethod.POST)
    public @ResponseBody Boolean isActiveToken(@RequestBody TokenRequest request) throws EmptyRequestException, NotFoundException {
        if (isObjectEmpty(request)) throw new EmptyRequestException();
        return Optional.of(authService.isActiveSession(request.getToken())).orElseThrow(NotFoundException::new);
    }

    @RequestMapping(value = REMOVE_TOKEN, method = RequestMethod.DELETE)
    public void removeToken(@RequestBody TokenRequest request) throws EmptyRequestException {
        if (isObjectEmpty(request)) throw new EmptyRequestException();
        authService.removeToken(request.getToken());
    }

}
