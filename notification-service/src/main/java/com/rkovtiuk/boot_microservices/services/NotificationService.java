package com.rkovtiuk.boot_microservices.services;

import com.rkovtiuk.boot_microservices.userclientlibs.domain.model.NotificationDTO;
import com.rkovtiuk.boot_microservices.userclientlibs.exception.NotFoundException;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface NotificationService {

    List<NotificationDTO> getUserNotification(Integer userId) throws NotFoundException;

    void removeNotification(Integer notificationId) throws NotFoundException;
}
