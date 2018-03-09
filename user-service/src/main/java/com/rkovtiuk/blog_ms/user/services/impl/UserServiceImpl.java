package com.rkovtiuk.blog_ms.user.services.impl;

import com.rkovtiuk.blog_ms.core.domain.models.UserDTO;
import com.rkovtiuk.blog_ms.core.domain.requests.user.SingUpRequest;
import com.rkovtiuk.blog_ms.core.domain.responses.user.LoginResponse;
import com.rkovtiuk.blog_ms.user.domain.converter.UserConverter;
import com.rkovtiuk.blog_ms.user.repository.UserRepository;
import com.rkovtiuk.blog_ms.user.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserConverter userMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserConverter userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public Optional<UserDTO> getUserById(Integer id){
        return userRepository.findById(id).map(userMapper::mapToView);
    }

    @Override
    public List<UserDTO> getUsers() {
        return userRepository.findAll().stream().map(userMapper::mapToView).collect(Collectors.toList());
    }

    @Override
    public Optional<LoginResponse> createUser(SingUpRequest newUser) {
        return userMapper.mapToLoginResponse(userRepository.save(userMapper.mapToEntity(newUser)));
    }

    @Override
    public Optional<LoginResponse> getLoginUser(String email, String password) {
        return userMapper.mapToLoginResponse(userRepository.findByEmailAndPassword(email, password));
    }
}
