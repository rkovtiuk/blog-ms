package com.rkovtiuk.blog_ms.user.services;

import com.rkovtiuk.blog_ms.userclientlibs.domain.model.UserDTO;

import java.util.List;

public interface UserService {
    UserDTO getUserById(Integer id);

    List<UserDTO> getUsers();
}
