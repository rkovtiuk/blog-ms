package com.rkovtiuk.boot_microservices.services;

import com.rkovtiuk.boot_microservices.userclientlibs.domain.model.UserDTO;

import java.util.List;

public interface UserService {
    UserDTO getUserById(Integer id);

    List<UserDTO> getUsers();
}
