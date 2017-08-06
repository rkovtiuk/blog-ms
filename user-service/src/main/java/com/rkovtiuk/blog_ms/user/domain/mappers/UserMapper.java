package com.rkovtiuk.blog_ms.user.domain.mappers;

import com.rkovtiuk.blog_ms.db.domain.entities.User;
import com.rkovtiuk.blog_ms.userclientlibs.domain.model.UserDTO;
import com.rkovtiuk.blog_ms.userclientlibs.domain.requests.user.UserCreateRequest;

public interface UserMapper {
    UserDTO map(Object user);
}
