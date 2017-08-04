package com.rkovtiuk.boot_microservices.domain.mappers.impl;

import com.rkovtiuk.boot_microservices.domain.entities.Notification;
import com.rkovtiuk.boot_microservices.domain.mappers.NotificationMapper;
import com.rkovtiuk.boot_microservices.userclientlibs.domain.model.NotificationDTO;
import org.springframework.stereotype.Component;

@Component
public class NotificationMapperImpl implements NotificationMapper {

    @Override
    public NotificationDTO map(Notification notification){
        NotificationDTO dto = new NotificationDTO();
        dto.setId(notification.getId());
        dto.setText(notification.getText());
        dto.setTitle(notification.getTitle());
        return dto;
    }

}
