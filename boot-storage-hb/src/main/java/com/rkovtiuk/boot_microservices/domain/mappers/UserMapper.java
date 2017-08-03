package com.rkovtiuk.boot_microservices.domain.mappers;

import com.rkovtiuk.boot_microservices.domain.entities.User;
import com.rkovtiuk.boot_microservices.userclientlibs.domain.model.UserView;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class UserMapper {

    public UserView mapUser(User user){
        if (user==null) return null;

        UserView view = new UserView();
        view.setId(user.getId());
        view.setForename(user.getForename());
        view.setSurname(user.getForename());
        view.setOrganisation(user.getOrganisation());
        view.setPoints(user.getPoints());
        return view;
    }


}
