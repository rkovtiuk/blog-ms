package com.rkovtiuk.blog_ms.user.controllers;

import com.rkovtiuk.blog_ms.user.services.UserService;
import com.rkovtiuk.blog_ms.core.domain.model.UserDTO;
import com.rkovtiuk.blog_ms.core.domain.requests.user.UserCreateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.rkovtiuk.blog_ms.core.utils.Path.UserApi.GET_USERS;
import static com.rkovtiuk.blog_ms.core.utils.Path.UserApi.GET_USER_DETAILS;
import static com.rkovtiuk.blog_ms.core.utils.Path.UserApi.PUT_USER;

@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(GET_USER_DETAILS)
    public UserDTO getUser(@RequestParam(value = "id", defaultValue = "1") int id){
        return userService.getUserById(id);
    }

    @RequestMapping(GET_USERS)
    public List<UserDTO> getUsers(){
        return userService.getUsers();
    }

    @RequestMapping(PUT_USER)
    public @ResponseBody UserDTO createUser(@RequestBody UserCreateRequest request) {
        return userService.createUser(request);
    }
}
