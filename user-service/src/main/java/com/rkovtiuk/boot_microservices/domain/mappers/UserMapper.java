package com.rkovtiuk.boot_microservices.domain.mappers;

import com.rkovtiuk.boot_microservices.domain.entities.User;
import com.rkovtiuk.boot_microservices.userclientlibs.domain.model.UserDTO;

public interface UserMapper {
    UserDTO mapUser(User user);
}
