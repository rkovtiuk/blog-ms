package com.rkovtiuk.blog_ms.user.services;

import com.rkovtiuk.blog_ms.core.domain.model.UserDTO;
import com.rkovtiuk.blog_ms.core.domain.requests.user.SingInRequest;
import com.rkovtiuk.blog_ms.core.domain.response.user.LoginResponse;

import java.util.List;

public interface UserService {
    UserDTO getUserById(Integer id);

    List<UserDTO> getUsers();

    LoginResponse createUser(SingInRequest user);
}
