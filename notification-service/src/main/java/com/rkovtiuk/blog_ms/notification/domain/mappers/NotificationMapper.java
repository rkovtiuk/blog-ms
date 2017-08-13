package com.rkovtiuk.blog_ms.notification.domain.mappers;

import com.rkovtiuk.blog_ms.core.domain.models.NotificationDTO;
import com.rkovtiuk.blog_ms.db.domain.entities.Notification;

public interface NotificationMapper {
    NotificationDTO map(Notification notification);
}
