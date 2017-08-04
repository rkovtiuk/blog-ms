package com.rkovtiuk.blog_ms.user.controllers;

import com.rkovtiuk.blog_ms.user.services.UserService;
import com.rkovtiuk.blog_ms.userclientlibs.domain.model.UserDTO;
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

    @RequestMapping("/user")
    public UserDTO getUser(@RequestParam(value = "id", defaultValue = "1") int id){
        return userService.getUserById(id);
    }

    @RequestMapping("/users")
    public List<UserDTO> getUsers(){
        return userService.getUsers();
    }
}
