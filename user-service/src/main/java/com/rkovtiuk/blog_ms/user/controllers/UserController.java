package com.rkovtiuk.blog_ms.user.controllers;

import com.rkovtiuk.blog_ms.core.domain.builders.CreateTokenRequestBuilder;
import com.rkovtiuk.blog_ms.core.domain.models.UserDTO;
import com.rkovtiuk.blog_ms.core.domain.requests.auth.CreateTokenRequest;
import com.rkovtiuk.blog_ms.core.domain.requests.user.SignInRequest;
import com.rkovtiuk.blog_ms.core.domain.requests.user.SingUpRequest;
import com.rkovtiuk.blog_ms.core.domain.responses.BaseResponse;
import com.rkovtiuk.blog_ms.core.domain.responses.user.LoginResponse;
import com.rkovtiuk.blog_ms.core.exception.EmailNotValidException;
import com.rkovtiuk.blog_ms.core.exception.EmptyRequestException;
import com.rkovtiuk.blog_ms.core.exception.PasswordDontMatchException;
import com.rkovtiuk.blog_ms.core.exception.WrongPassOrEmailException;
import com.rkovtiuk.blog_ms.core.utils.ExceptUtils;
import com.rkovtiuk.blog_ms.core.utils.Path;
import com.rkovtiuk.blog_ms.user.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

import static com.rkovtiuk.blog_ms.core.utils.NetworkUtils.createTokenHeader;
import static com.rkovtiuk.blog_ms.core.utils.Path.AuthApi.TOKEN_HEADER_NAME;
import static com.rkovtiuk.blog_ms.core.utils.Path.UserApi.*;
import static com.rkovtiuk.blog_ms.core.utils.Validator.isObjectEmpty;
import static com.rkovtiuk.blog_ms.core.utils.Validator.isValidEmailAddress;

@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    private String getSessionToken(Integer id){
        RestTemplate rest = new RestTemplate();
        CreateTokenRequest request = new CreateTokenRequestBuilder().setUserId(id).build();
        return rest.postForObject(Path.AuthApi.CREATE_TOKEN, request, String.class);
    }

    @RequestMapping(value = GET_USER_DETAILS, method = RequestMethod.GET)
    public UserDTO getUser(@RequestParam(value = "id", defaultValue = "1") int id){
        return userService.getUserById(id);
    }

    @RequestMapping(value = GET_USER_ID_BY_TOKEN, method = RequestMethod.GET)
    public Integer getUserId(@RequestHeader(value = TOKEN_HEADER_NAME) String token) throws EmptyRequestException {
        if (token==null) throw new EmptyRequestException();
        return new RestTemplate().postForObject(Path.AuthApi.CREATE_TOKEN, null, Integer.class, createTokenHeader(token));
    }

    @RequestMapping(value = GET_USERS, method = RequestMethod.GET)
    public List<UserDTO> getUsers(){
        return userService.getUsers();
    }

    @RequestMapping(value = SIGN_UP, method = RequestMethod.POST)
    @ResponseBody
    public LoginResponse createUser(@RequestBody SingUpRequest request) throws Exception {
        if (isObjectEmpty(request)) throw new EmptyRequestException();
        if (isValidEmailAddress(request.getEmail())) throw new EmailNotValidException();
        if (request.getPassword().equals(request.getConfirmPassword())) throw  new PasswordDontMatchException();

        Optional<LoginResponse> user = userService.createUser(request);
        user.orElseThrow(Exception::new).setSessionToken(getSessionToken(user.get().getId()));
        return user.get();
    }

    @RequestMapping(value = SIGN_IN, method = RequestMethod.POST)
    @ResponseBody
    public LoginResponse login(@RequestBody SignInRequest request) throws EmptyRequestException, EmailNotValidException, WrongPassOrEmailException {
        if (isObjectEmpty(request)) throw new EmptyRequestException();
        if (isValidEmailAddress(request.getEmail())) throw new EmailNotValidException();

        Optional<LoginResponse> response = userService.getLoginUser(request.getEmail(), request.getPassword());
        response.orElseThrow(WrongPassOrEmailException::new)
                .setSessionToken(getSessionToken(response.get().getId()));
        return response.get();
    }

    @ExceptionHandler
    public ResponseEntity<BaseResponse> dummyExceptionHandler(Exception e) {
        return ExceptUtils.responseData(e);
    }
}
