package com.rkovtiuk.blog_ms.auth;

import com.rkovtiuk.blog_ms.auth.service.TokenAuthService;
import com.rkovtiuk.blog_ms.auth.service.UserAuthService;
import com.rkovtiuk.blog_ms.auth.web.filters.StatelessAuthFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@ComponentScan({"com.rkovtiuk.blog_ms.db", "com.rkovtiuk.blog_ms.auth"})
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserAuthService userAuthService;

    @Autowired
    private TokenAuthService tokenAuthService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .addFilterBefore(new StatelessAuthFilter(tokenAuthService), UsernamePasswordAuthenticationFilter.class)
                .authorizeRequests()
                .antMatchers("/readme.txt", "/css/*").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin().loginPage("/login").permitAll()
                .and()
                .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).permitAll();
    }

    @Bean
    public PasswordEncoder bcryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userAuthService)
                .passwordEncoder(bcryptPasswordEncoder());
    }
}
