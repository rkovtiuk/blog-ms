package com.rkovtiuk.blog_ms.user.domain.mappers;

import com.rkovtiuk.blog_ms.core.domain.entities.User;
import com.rkovtiuk.blog_ms.core.domain.models.UserDTO;
import com.rkovtiuk.blog_ms.core.domain.responses.user.LoginResponse;

import java.util.Optional;

public interface UserMapper {
    UserDTO mapToView(Object user);

    User mapToEntity(Object user);

    Optional<LoginResponse> mapToLoginResponse(User save);
}
