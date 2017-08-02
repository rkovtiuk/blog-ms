package com.rkovtiuk.boot_microservices.mvc.controller;


import com.rkovtiuk.boot_microservices.userclientlibs.domain.dto.UserView;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class UserNotificationController {


    @RequestMapping("/notification")
    public String getUser(@RequestParam(value="id", defaultValue="1") int id) {
        RestTemplate restTemplate = new RestTemplate();
        UserView user = restTemplate.getForObject("http://localhost:9001/user?id="+id, UserView.class);
        StringBuilder response = new StringBuilder("NOTIFICATIONS");
        int number = 1;
        for(String notification : user.getNotifications()){
            response.append("<BR> Notification number ").append(number++).append(": ").append(notification);
        }
        return response.toString();
    }

}
