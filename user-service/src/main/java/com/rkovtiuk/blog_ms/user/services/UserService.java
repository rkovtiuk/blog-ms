package com.rkovtiuk.blog_ms.user.services;

import com.rkovtiuk.blog_ms.core.domain.models.UserDTO;
import com.rkovtiuk.blog_ms.core.domain.requests.user.SingUpRequest;
import com.rkovtiuk.blog_ms.core.domain.responses.user.LoginResponse;

import java.util.List;
import java.util.Optional;

public interface UserService {
    Optional<UserDTO> getUserById(Integer id);

    List<UserDTO> getUsers();

    Optional<LoginResponse> createUser(SingUpRequest user);

    Optional<LoginResponse> getLoginUser(String email, String password);
}
