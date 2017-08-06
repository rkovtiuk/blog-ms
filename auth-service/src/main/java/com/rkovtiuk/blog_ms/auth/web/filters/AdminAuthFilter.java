package com.rkovtiuk.blog_ms.auth.web.filters;

import com.rkovtiuk.blog_ms.auth.domain.UserAuthentication;
import com.rkovtiuk.blog_ms.auth.service.UserAuthService;
import com.rkovtiuk.blog_ms.db.domain.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import javax.annotation.PostConstruct;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

public class AdminAuthFilter extends GenericFilterBean{

    @Autowired
    private UserAuthService userAuthService;
    private User admin;

    @PostConstruct
    public void init() {
        admin = (User) userAuthService.loadUserByUsername("admin");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        SecurityContextHolder.getContext().setAuthentication(new UserAuthentication(admin));
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
