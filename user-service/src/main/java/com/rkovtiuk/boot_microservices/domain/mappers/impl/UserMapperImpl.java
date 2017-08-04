package com.rkovtiuk.boot_microservices.domain.mappers.impl;

import com.rkovtiuk.boot_microservices.domain.entities.User;
import com.rkovtiuk.boot_microservices.domain.mappers.UserMapper;
import com.rkovtiuk.boot_microservices.userclientlibs.domain.model.UserDTO;
import org.springframework.stereotype.Component;

@Component
public class UserMapperImpl implements UserMapper{

    @Override
    public UserDTO mapUser(User user){
        if (user==null) return null;

        UserDTO view = new UserDTO();
        view.setId(user.getId());
        view.setForename(user.getForename());
        view.setSurname(user.getForename());
        view.setOrganisation(user.getOrganisation());
        view.setPoints(user.getPoints());
        return view;
    }


}
