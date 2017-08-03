package com.rkovtiuk.boot_microservices.repository;


import com.rkovtiuk.boot_microservices.domain.entities.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface UserRepository extends Repository<User, Integer> {

    User findById(Integer id);

    void save(User user);

    List<User> findAll();
}
