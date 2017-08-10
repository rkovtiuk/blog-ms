package com.rkovtiuk.blog_ms.auth.service;

import com.rkovtiuk.blog_ms.auth.domain.models.AuthUser;
import com.rkovtiuk.blog_ms.auth.repository.AuthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserAuthService
//        implements UserDetailsService
{

    @Autowired
    private AuthRepository repository;

//    @Override
//    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
//        AuthUser user = repository.findByUsername(name);
//        if (user==null) throw new UsernameNotFoundException("User: "+name+" was not found");
//        return user;
//    }

    public Optional<AuthUser> findById(Integer id){
        return repository.findById(id);
    }
}
