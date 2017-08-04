package com.rkovtiuk.blog_ms.user.repository;


import com.rkovtiuk.blog_ms.db.domain.entities.User;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface UserRepository extends Repository<User, Integer> {

    User findById(Integer id);

    void save(User user);

    List<User> findAll();
}
