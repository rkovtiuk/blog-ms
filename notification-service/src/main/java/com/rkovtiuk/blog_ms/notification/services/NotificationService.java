package com.rkovtiuk.blog_ms.notification.services;

import com.rkovtiuk.blog_ms.core.domain.models.NotificationDTO;
import com.rkovtiuk.blog_ms.core.exception.NotFoundException;

import java.util.List;

public interface NotificationService {

    List<NotificationDTO> getUserNotification(Integer userId) throws NotFoundException;

    void removeNotification(Integer notificationId) throws NotFoundException;
}
