package com.rkovtiuk.blog_ms.user.domain.converter;

import com.rkovtiuk.blog_ms.core.domain.entities.User;
import com.rkovtiuk.blog_ms.core.domain.models.UserDTO;
import com.rkovtiuk.blog_ms.core.domain.requests.user.SingUpRequest;
import com.rkovtiuk.blog_ms.core.domain.responses.user.LoginResponse;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserConverter {

    public UserDTO mapToView(Object user){
        UserDTO view = null;
        if (user==null) {
            return null;
        } else if (user instanceof User) {
            User userModel = (User) user;
            view = createUser(
                userModel.getForename(),
                userModel.getSurname(),
                userModel.getOrganisation(),
                userModel.getPoints());
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

    public User mapToEntity(Object user){
        User entity = null;
        if (user == null)
            return null;
        else if (user instanceof SingUpRequest) {
            entity = new User();
            entity.setEmail(((SingUpRequest) user).getForename());
            entity.setForename(((SingUpRequest) user).getForename());
            entity.setSurname(((SingUpRequest) user).getSurname());
            entity.setOrganisation(((SingUpRequest) user).getOrganisation());
            entity.setPassword(((SingUpRequest) user).getPassword());
        }
        return entity;
    }

    public Optional<LoginResponse> mapToLoginResponse(User user) {
        LoginResponse response = new LoginResponse();
        response.setId(user.getId());
        response.setEmail(user.getEmail());
        response.setForename(user.getForename());
        response.setSurname(user.getSurname());
        response.setOrganisation(user.getOrganisation());
        response.setPoints(user.getPoints());
        return Optional.of(response);
    }
}
