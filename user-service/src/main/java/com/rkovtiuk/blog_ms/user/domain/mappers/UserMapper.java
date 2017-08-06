package com.rkovtiuk.blog_ms.user.domain.mappers;

import com.rkovtiuk.blog_ms.core.domain.model.UserDTO;
import com.rkovtiuk.blog_ms.db.domain.entities.User;

public interface UserMapper {
    UserDTO mapToView(Object user);

    User mapToEntity(Object user);
}
