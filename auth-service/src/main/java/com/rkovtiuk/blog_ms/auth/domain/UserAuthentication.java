package com.rkovtiuk.blog_ms.auth.domain;

import com.rkovtiuk.blog_ms.db.domain.entities.AuthUser;
import com.rkovtiuk.blog_ms.db.domain.entities.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class UserAuthentication implements Authentication{

    private final AuthUser user;
    private boolean authenticated = true;

    public UserAuthentication(AuthUser user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return user.getAuthorities();
    }

    @Override
    public Object getCredentials() {
        return user.getPassword();
    }

    @Override
    public Object getDetails() {
        return user;
    }

    @Override
    public Object getPrincipal() {
        return user;
    }

    @Override
    public boolean isAuthenticated() {
        return authenticated;
    }

    @Override
    public void setAuthenticated(boolean b) throws IllegalArgumentException {
        this.authenticated = isAuthenticated();
    }

    @Override
    public String getName() {
        return user.getUsername();
    }
}
