package com.rkvotiuk.boot_microservices.mvc.controllers;

import com.rkovtiuk.boot_microservices.userclientlibs.domain.model.UserView;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import static com.rkovtiuk.boot_microservices.userclientlibs.utils.Path.DB_API_CREATE_USER;
import static com.rkovtiuk.boot_microservices.userclientlibs.utils.Path.DB_API_GET_USER;

@RestController
public class UserController {

    @RequestMapping("/user")
    public UserView getUser(@RequestParam(value = "id", defaultValue = "1") int id){
        RestTemplate restTemplate = new RestTemplate();
        UserView user = restTemplate.getForObject(DB_API_GET_USER+id, UserView.class);
        return user;
    }

}
