package com.rkovtiuk.blog_ms.auth.controllers;

import com.rkovtiuk.blog_ms.auth.service.AuthService;
import com.rkovtiuk.blog_ms.core.domain.requests.auth.CreateTokenRequest;
import com.rkovtiuk.blog_ms.core.domain.requests.auth.TokenRequest;
import com.rkovtiuk.blog_ms.core.domain.response.BaseResponse;
import com.rkovtiuk.blog_ms.core.exception.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.rkovtiuk.blog_ms.core.utils.Path.AuthApi.*;
import static com.rkovtiuk.blog_ms.core.utils.Validator.isEmpty;

@RestController
public class AuthController {

    @Autowired
    private AuthService authService;

    @RequestMapping(value = CREATE_TOKEN)
    public @ResponseBody String createToken(@RequestBody CreateTokenRequest request){
        return authService.createToken(request);
    }

    @RequestMapping(value = USER_ID_BY_TOKEN, method = RequestMethod.POST)
    public @ResponseBody Integer getUserId(@RequestBody TokenRequest request) throws EmptyRequestException {
        if (isNotValidTokenRequest(request)) throw new EmptyRequestException();
        return authService.getUserIdByToken(request.getToken());
    }

    @RequestMapping(value = ACTIVE_TOKEN, method = RequestMethod.POST)
    public @ResponseBody Boolean isActiveToken(@RequestBody TokenRequest request) throws EmptyRequestException {
        if (isNotValidTokenRequest(request)) throw new EmptyRequestException();
        return authService.isActiveSession(request.getToken());
    }

    @RequestMapping(value = REMOVE_TOKEN, method = RequestMethod.DELETE)
    public void removeToken(@RequestBody TokenRequest request) throws EmptyRequestException {
        if (isNotValidTokenRequest(request)) throw new EmptyRequestException();
        authService.removeToken(request.getToken());
    }

    private boolean isNotValidTokenRequest(final TokenRequest request){
        return request==null || isEmpty(request.getToken());
    }

    @ExceptionHandler
    public ResponseEntity<BaseResponse> dummyExceptionHandler(Exception e) {
        if (e instanceof NotFoundException)
            return new ResponseEntity<>(new BaseResponse(e.getMessage()), HttpStatus.NOT_FOUND);
        if (e instanceof WrongPassOrEmailException)
            return new ResponseEntity<>(new BaseResponse(e.getMessage()), HttpStatus.BAD_REQUEST);
        if (e instanceof EmptyRequestException)
            return new ResponseEntity<>(new BaseResponse(e.getMessage()), HttpStatus.BAD_REQUEST);
        if (e instanceof EmailNotValidException)
            return new ResponseEntity<>(new BaseResponse(e.getMessage()), HttpStatus.BAD_REQUEST);
        if (e instanceof PasswordDontMatch)
            return new ResponseEntity<>(new BaseResponse(e.getMessage()), HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(new BaseResponse("Unexpected exception"), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
