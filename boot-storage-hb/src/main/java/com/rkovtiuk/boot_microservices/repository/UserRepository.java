package com.rkovtiuk.boot_microservices.repository;


import com.rkovtiuk.boot_microservices.domain.entities.User;
import com.rkovtiuk.boot_microservices.userclientlibs.domain.model.UserView;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface UserRepository extends Repository<User, Integer> {

    User findOne(Integer id);

    void save(User user);

    List<User> findAll();
}
