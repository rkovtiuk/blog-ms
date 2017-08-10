package com.rkovtiuk.blog_ms.user.domain.mappers.impl;

import com.rkovtiuk.blog_ms.db.domain.entities.User;
import com.rkovtiuk.blog_ms.user.domain.mappers.UserMapper;
import com.rkovtiuk.blog_ms.core.domain.model.UserDTO;
import com.rkovtiuk.blog_ms.core.domain.requests.user.SingInRequest;
import org.springframework.stereotype.Component;

@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDTO mapToView(Object user){
        UserDTO view = null;
        if (user==null) {
            return null;
        } else if (user instanceof User) {
            User userModel = (User) user;
            view = createUser(userModel.getForename(), userModel.getSurname(), userModel.getOrganisation(), userModel.getPoints());
            view.setId(userModel.getId());
        }

        return view;
    }

    private UserDTO createUser(String forename, String surname, String organisation, long points){
        UserDTO view = new UserDTO();
        view.setForename(forename);
        view.setSurname(surname);
        view.setOrganisation(organisation);
        view.setPoints(points);
        return view;
    }

    @Override
    public User mapToEntity(Object user){
        User entity = null;
        if (user == null)
            return null;
        else if (user instanceof SingInRequest) {
            entity = new User();
            entity.setEmail(((SingInRequest) user).getForename());
            entity.setForename(((SingInRequest) user).getForename());
            entity.setSurname(((SingInRequest) user).getSurname());
            entity.setOrganisation(((SingInRequest) user).getOrganisation());
            entity.setPassword(((SingInRequest) user).getPassword());
        }
        return entity;
    }
}
