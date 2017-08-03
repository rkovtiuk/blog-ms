package com.rkovtiuk.boot_microservices.services;

import com.rkovtiuk.boot_microservices.domain.entities.User;
import com.rkovtiuk.boot_microservices.domain.mappers.UserMapper;
import com.rkovtiuk.boot_microservices.repository.UserRepository;
import com.rkovtiuk.boot_microservices.userclientlibs.domain.model.UserView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Autowired
    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public UserView getUserById(Integer id){
        User user = userRepository.findOne(id);
        return userMapper.mapUser(user);
    }


    public List<UserView> getUsers() {
        return userRepository.findAll().stream().map(userMapper::mapUser).collect(Collectors.toList());
    }
}
