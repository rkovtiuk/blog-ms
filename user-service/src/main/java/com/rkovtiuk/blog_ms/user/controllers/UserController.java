package com.rkovtiuk.blog_ms.user.controllers;

import com.rkovtiuk.blog_ms.core.domain.model.SessionTokenDTO;
import com.rkovtiuk.blog_ms.core.domain.response.BaseResponse;
import com.rkovtiuk.blog_ms.core.domain.response.user.LoginResponse;
import com.rkovtiuk.blog_ms.core.exception.EmailNotValidException;
import com.rkovtiuk.blog_ms.core.exception.EmptyRequestException;
import com.rkovtiuk.blog_ms.core.exception.PasswordDontMatch;
import com.rkovtiuk.blog_ms.user.services.UserService;
import com.rkovtiuk.blog_ms.core.domain.model.UserDTO;
import com.rkovtiuk.blog_ms.core.domain.requests.user.SingInRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static com.rkovtiuk.blog_ms.core.utils.Path.UserApi.GET_USERS;
import static com.rkovtiuk.blog_ms.core.utils.Path.UserApi.GET_USER_DETAILS;
import static com.rkovtiuk.blog_ms.core.utils.Path.UserApi.SIGN_UP;
import static com.rkovtiuk.blog_ms.core.utils.Validator.isEmpty;
import static com.rkovtiuk.blog_ms.core.utils.Validator.isValidEmailAddress;

@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = GET_USER_DETAILS, method = RequestMethod.GET)
    public UserDTO getUser(@RequestParam(value = "id", defaultValue = "1") int id){
        return userService.getUserById(id);
    }

    @RequestMapping(value = GET_USERS, method = RequestMethod.GET)
    public List<UserDTO> getUsers(){
        return userService.getUsers();
    }

    @RequestMapping(value = SIGN_UP, method = RequestMethod.POST)
    @ResponseBody
    public LoginResponse createUser(@RequestBody SingInRequest request) throws EmptyRequestException, EmailNotValidException, PasswordDontMatch {
        if (request==null || isEmpty(request.getEmail()) || isEmpty(request.getForename()) || isEmpty(request.getSurname()) || isEmpty(request.getPassword()) || isEmpty(request.getConfirmPassword())) throw new EmptyRequestException();
        if (isValidEmailAddress(request.getEmail())) throw new EmailNotValidException();
        if (request.getPassword().equals(request.getConfirmPassword())) throw  new PasswordDontMatch();
        LoginResponse user = userService.createUser(request);
        user.setSessionToken(getSessionToken(request.getEmail(), request.getPassword()));
        return user;
    }

    public String getSessionToken(String email, String password){
//        RestTemplate rest = new RestTemplate();
//        rest.
        return "123123123";
    }

    @ExceptionHandler
    public ResponseEntity<BaseResponse> dummyExceptionHandler(Exception e) {
        if (e instanceof EmptyRequestException)
            return new ResponseEntity<>(new BaseResponse(e.getMessage()), HttpStatus.BAD_REQUEST);
        if (e instanceof EmailNotValidException)
            return new ResponseEntity<>(new BaseResponse(e.getMessage()), HttpStatus.BAD_REQUEST);
        if (e instanceof PasswordDontMatch)
            return new ResponseEntity<>(new BaseResponse(e.getMessage()), HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(new BaseResponse("Unexpected exception"), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
