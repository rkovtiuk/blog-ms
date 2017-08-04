package com.rkovtiuk.blog_ms.user.domain.mappers;

import com.rkovtiuk.blog_ms.db.domain.entities.User;
import com.rkovtiuk.blog_ms.userclientlibs.domain.model.UserDTO;

public interface UserMapper {
    UserDTO mapUser(User user);
}
