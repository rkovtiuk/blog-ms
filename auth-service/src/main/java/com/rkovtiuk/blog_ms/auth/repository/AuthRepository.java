package com.rkovtiuk.blog_ms.auth.repository;

import com.rkovtiuk.blog_ms.db.domain.entities.Token;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

public interface AuthRepository extends CrudRepository<Token, Integer> {

    Token findBySessionToken(String sessionToken);

    void removeBySessionToken(String token);
}
