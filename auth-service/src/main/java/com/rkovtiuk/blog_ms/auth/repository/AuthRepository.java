package com.rkovtiuk.blog_ms.auth.repository;

import com.rkovtiuk.blog_ms.db.domain.entities.AuthUser;
import com.rkovtiuk.blog_ms.db.domain.entities.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AuthRepository extends CrudRepository<AuthUser, Integer> {

    AuthUser findByUsername(String name);

    Optional<AuthUser> findById(Integer id);
}
