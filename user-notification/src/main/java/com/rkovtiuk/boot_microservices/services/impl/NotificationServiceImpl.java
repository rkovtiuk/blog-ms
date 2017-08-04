package com.rkovtiuk.boot_microservices.services.impl;

import com.rkovtiuk.boot_microservices.domain.mappers.impl.NotificationMapperImpl;
import com.rkovtiuk.boot_microservices.repository.NotificationRepository;
import com.rkovtiuk.boot_microservices.services.NotificationService;
import com.rkovtiuk.boot_microservices.userclientlibs.domain.model.NotificationDTO;
import com.rkovtiuk.boot_microservices.userclientlibs.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NotificationServiceImpl implements NotificationService{

    private final NotificationRepository repository;
    private final NotificationMapperImpl mapper;

    @Autowired
    public NotificationServiceImpl(NotificationRepository repository, NotificationMapperImpl mapper) {
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
