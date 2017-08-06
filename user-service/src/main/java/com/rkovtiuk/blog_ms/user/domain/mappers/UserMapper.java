package com.rkovtiuk.blog_ms.user.domain.mappers;

import com.rkovtiuk.blog_ms.core.domain.model.UserDTO;

public interface UserMapper {
    UserDTO map(Object user);
}
