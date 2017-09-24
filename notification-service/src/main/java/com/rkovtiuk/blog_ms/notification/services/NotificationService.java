package com.rkovtiuk.blog_ms.notification.services;

import com.rkovtiuk.blog_ms.core.domain.models.NotificationDTO;

import java.util.List;

public interface NotificationService {

    List<NotificationDTO> getUserNotification(Integer userId);

    boolean removeNotification(Integer notificationId);
}
