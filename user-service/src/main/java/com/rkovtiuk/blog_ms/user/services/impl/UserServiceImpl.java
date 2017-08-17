package com.rkovtiuk.blog_ms.user.services.impl;

import com.rkovtiuk.blog_ms.core.domain.models.UserDTO;
import com.rkovtiuk.blog_ms.core.domain.requests.user.SingUpRequest;
import com.rkovtiuk.blog_ms.core.domain.responses.user.LoginResponse;
import com.rkovtiuk.blog_ms.core.domain.entities.User;
import com.rkovtiuk.blog_ms.user.domain.mappers.UserMapper;
import com.rkovtiuk.blog_ms.user.repository.UserRepository;
import com.rkovtiuk.blog_ms.user.services.UserService;
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
        return userMapper.mapToView(user);
    }

    @Override
    public List<UserDTO> getUsers() {
        return userRepository.findAll().stream().map(userMapper::mapToView).collect(Collectors.toList());
    }

    @Override
    public LoginResponse createUser(SingUpRequest newUser) {
        return userMapper.mapToLoginResponse(userRepository.save(userMapper.mapToEntity(newUser)));
    }

    @Override
    public LoginResponse getLoginUser(String email, String password) {
        return userMapper.mapToLoginResponse(userRepository.findByEmailAndPassword(email, password));
    }
}
