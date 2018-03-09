package com.rkovtiuk.blog_ms.user.repository;

import com.rkovtiuk.blog_ms.core.domain.entities.User;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends Repository<User, Integer> {

    Optional<User> findById(Integer id);

    List<User> findAll();

    User save(User user);

    User findByEmailAndPassword(String email, String password);
}
