package com.rkovtiuk.boot_microservices.services.impl;

import com.rkovtiuk.boot_microservices.domain.entities.User;
import com.rkovtiuk.boot_microservices.domain.mappers.UserMapper;
import com.rkovtiuk.boot_microservices.domain.mappers.impl.UserMapperImpl;
import com.rkovtiuk.boot_microservices.repository.UserRepository;
import com.rkovtiuk.boot_microservices.services.UserService;
import com.rkovtiuk.boot_microservices.userclientlibs.domain.model.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public UserDTO getUserById(Integer id){
        User user = userRepository.findById(id);
        return userMapper.mapUser(user);
    }

    @Override
    public List<UserDTO> getUsers() {
        return userRepository.findAll().stream().map(userMapper::mapUser).collect(Collectors.toList());
    }
}
