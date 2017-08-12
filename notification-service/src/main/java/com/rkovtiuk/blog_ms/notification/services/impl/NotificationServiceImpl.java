package com.rkovtiuk.blog_ms.notification.services.impl;

import com.rkovtiuk.blog_ms.notification.domain.mappers.NotificationMapper;
import com.rkovtiuk.blog_ms.notification.repository.NotificationRepository;
import com.rkovtiuk.blog_ms.notification.services.NotificationService;
import com.rkovtiuk.blog_ms.core.domain.models.NotificationDTO;
import com.rkovtiuk.blog_ms.core.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NotificationServiceImpl implements NotificationService{

    private final NotificationRepository repository;
    private final NotificationMapper mapper;

    @Autowired
    public NotificationServiceImpl(NotificationRepository repository, NotificationMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<NotificationDTO> getUserNotification(Integer userId) throws NotFoundException {
        if (userId == null) throw new NotFoundException();
        return repository.findAllByUserId(userId)
                .stream().map(mapper::map).collect(Collectors.toList());
    }

    @Override
    public void removeNotification(Integer notificationId) throws NotFoundException {
        if (notificationId == null) throw new NotFoundException();
        if (repository.getById(notificationId)==null) throw new NotFoundException();
        repository.removeById(notificationId);
    }


}
