package com.rkovtiuk.boot_microservices.controller;

import com.rkovtiuk.boot_microservices.domain.requests.NotificationRequest;
import com.rkovtiuk.boot_microservices.services.NotificationService;
import com.rkovtiuk.boot_microservices.userclientlibs.domain.model.NotificationDTO;
import com.rkovtiuk.boot_microservices.userclientlibs.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserNotificationController {

    private final NotificationService service;

    @Autowired
    public UserNotificationController(NotificationService service) {
        this.service = service;
    }

    @RequestMapping(value = "user/notifications", method = RequestMethod.POST)
    public List<NotificationDTO> getUser(@RequestBody NotificationRequest request) {
        try {
            return service.getUserNotification(request.getId());
        } catch (NotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

}
