package com.rkovtiuk.blog_ms.notification.domain.mappers;

import com.rkovtiuk.blog_ms.db.domain.entities.Notification;
import com.rkovtiuk.blog_ms.core.domain.model.NotificationDTO;

public interface NotificationMapper {
    NotificationDTO map(Notification notification);
}
