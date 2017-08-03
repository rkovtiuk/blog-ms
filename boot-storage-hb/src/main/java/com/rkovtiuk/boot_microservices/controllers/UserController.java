package com.rkovtiuk.boot_microservices.controllers;

import com.rkovtiuk.boot_microservices.services.UserService;
import com.rkovtiuk.boot_microservices.userclientlibs.domain.model.UserView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("user")
    public UserView getUser(@RequestParam(value = "id", defaultValue = "1") int id){
        return userService.getUserById(id);
    }

    @RequestMapping("users")
    public List<UserView> getUsers(){
        return userService.getUsers();
    }

}
