package com.rkovtiuk.blog_ms.notification.controller;

import com.rkovtiuk.blog_ms.notification.domain.requests.NotificationRequest;
import com.rkovtiuk.blog_ms.notification.services.NotificationService;
import com.rkovtiuk.blog_ms.userclientlibs.domain.model.NotificationDTO;
import com.rkovtiuk.blog_ms.userclientlibs.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NotificationController {

    private final NotificationService service;

    @Autowired
    public NotificationController(NotificationService service) {
        this.service = service;
    }

    @RequestMapping(value = "user/notifications", method = RequestMethod.POST)
    public  @ResponseBody List<NotificationDTO> getUser(@RequestBody NotificationRequest request) {
        try {
            return service.getUserNotification(request.getId());
        } catch (NotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

}
