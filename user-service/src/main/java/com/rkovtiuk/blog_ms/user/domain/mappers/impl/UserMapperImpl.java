package com.rkovtiuk.blog_ms.user.domain.mappers.impl;

import com.rkovtiuk.blog_ms.db.domain.entities.User;
import com.rkovtiuk.blog_ms.user.domain.mappers.UserMapper;
import com.rkovtiuk.blog_ms.core.domain.model.UserDTO;
import com.rkovtiuk.blog_ms.core.domain.requests.user.UserCreateRequest;
import org.springframework.stereotype.Component;

@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDTO map(Object user){
        UserDTO view = null;
        if (user==null) {
            return null;
        } else if (user instanceof User) {
            User userModel = (User) user;
            view = createUser(userModel.getForename(), userModel.getSurname(), userModel.getOrganisation(), userModel.getPoints());
            view.setId(userModel.getId());
        } else if (user instanceof UserCreateRequest){
            UserCreateRequest userModel = (UserCreateRequest) user;
            view = createUser(userModel.getForename(), userModel.getSurname(), userModel.getOrganisation(), userModel.getPoints());
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
}
