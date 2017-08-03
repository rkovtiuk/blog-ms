package com.rkovtiuk.boot_microsevices.mvc.controller;

import com.rkovtiuk.boot_microservices.userclientlibs.domain.model.UserDTO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class UserDashboardController {

    @RequestMapping("/dashboard")
    public String getUser(@RequestParam(value = "id", defaultValue = "1") int id){
        RestTemplate restTemplate = new RestTemplate();
        UserDTO user = restTemplate.getForObject("http://localhost:9001/user?id"+id, UserDTO.class);
        return "Welcome " + user.getForename() +" "+user.getSurname()+"<br>"+
                "You have " +user.getPoints() + " points! Good job!<br>"+
                "<br>"+
                "<br>"+user.getOrganisation();
    }

}
