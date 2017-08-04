package com.rkovtiuk.boot_microservices.repository;

import com.rkovtiuk.boot_microservices.domain.entities.Notification;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface NotificationRepository extends Repository<Notification, Integer> {


}
