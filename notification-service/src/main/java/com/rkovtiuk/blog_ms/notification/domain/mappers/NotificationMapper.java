package com.rkovtiuk.blog_ms.notification.domain.mappers;

import com.rkovtiuk.blog_ms.core.domain.entities.Notification;
import com.rkovtiuk.blog_ms.core.domain.models.NotificationDTO;

public interface NotificationMapper {
    NotificationDTO map(Notification notification);
}
