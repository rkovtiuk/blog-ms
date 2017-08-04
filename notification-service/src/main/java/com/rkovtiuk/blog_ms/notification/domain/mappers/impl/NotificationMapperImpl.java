package com.rkovtiuk.blog_ms.notification.domain.mappers.impl;

import com.rkovtiuk.blog_ms.db.domain.entities.Notification;
import com.rkovtiuk.blog_ms.notification.domain.mappers.NotificationMapper;
import com.rkovtiuk.blog_ms.userclientlibs.domain.model.NotificationDTO;
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
