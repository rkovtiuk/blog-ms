package com.rkovtiuk.blog_ms.auth;

//@Configuration
//@ComponentScan({"com.rkovtiuk.blog_ms.db", "com.rkovtiuk.blog_ms.auth"})
//@EnableWebSecurity
public class SecurityConfig
//        extends WebSecurityConfigurerAdapter
{

//    @Autowired
//    private UserAuthService userAuthService;
//
//    @Autowired
//    private TokenAuthService tokenAuthService;
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .addFilterBefore(new StatelessAuthFilter(tokenAuthService), UsernamePasswordAuthenticationFilter.class)
//                .authorizeRequests()
//                .antMatchers("/readme.txt", "/css/*").permitAll()
//                .anyRequest().authenticated()
//                .and()
//                .formLogin().loginPage("/login").permitAll()
//                .and()
//                .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).permitAll();
//    }
//
//    @Bean
//    public PasswordEncoder bcryptPasswordEncoder(){
//        return new BCryptPasswordEncoder();
//    }
//
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth
//                .userDetailsService(userAuthService)
//                .passwordEncoder(bcryptPasswordEncoder());
//    }
}
