package com.rkovtiuk.boot_microservices.domain.mappers;

import com.rkovtiuk.boot_microservices.domain.entities.Notification;
import com.rkovtiuk.boot_microservices.userclientlibs.domain.model.NotificationDTO;

public interface NotificationMapper {
    NotificationDTO map(Notification notification);
}
