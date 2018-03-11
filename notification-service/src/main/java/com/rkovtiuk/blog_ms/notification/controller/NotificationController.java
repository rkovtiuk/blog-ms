package com.rkovtiuk.blog_ms.notification.controller;

import com.rkovtiuk.blog_ms.core.domain.models.NotificationDTO;
import com.rkovtiuk.blog_ms.core.domain.requests.notifications.NotificationRequest;
import com.rkovtiuk.blog_ms.core.exception.EmptyRequestException;
import com.rkovtiuk.blog_ms.notification.services.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.rkovtiuk.blog_ms.core.utils.Validator.isObjectEmpty;

@RestController
public class NotificationController {

    private final NotificationService service;

    @Autowired
    public NotificationController(NotificationService service) {
        this.service = service;
    }

    @RequestMapping(value = "user/notifications", method = RequestMethod.POST)
    public  @ResponseBody List<NotificationDTO> getUser(@RequestBody NotificationRequest request) throws EmptyRequestException {
        if (isObjectEmpty(request)) throw new EmptyRequestException();
        return service.getUserNotification(request.getId());
    }

}
