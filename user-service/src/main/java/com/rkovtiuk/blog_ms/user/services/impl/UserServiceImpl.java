package com.rkovtiuk.blog_ms.user.services.impl;

import com.rkovtiuk.blog_ms.db.domain.entities.User;
import com.rkovtiuk.blog_ms.user.domain.mappers.UserMapper;
import com.rkovtiuk.blog_ms.user.repository.UserRepository;
import com.rkovtiuk.blog_ms.user.services.UserService;
import com.rkovtiuk.blog_ms.core.domain.model.UserDTO;
import com.rkovtiuk.blog_ms.core.domain.requests.user.UserCreateRequest;
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
        return userMapper.map(user);
    }

    @Override
    public List<UserDTO> getUsers() {
        return userRepository.findAll().stream().map(userMapper::map).collect(Collectors.toList());
    }

    @Override
    public UserDTO createUser(UserCreateRequest newUser) {
        User user = null;
//        user = userRepository.createUser(newUser);
        return userMapper.map(user);
    }
}
