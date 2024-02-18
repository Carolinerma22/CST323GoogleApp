package com.gcu.milestone;

import com.gcu.milestone.business.UserBusinessService;
import com.gcu.milestone.business.UserBusinessServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebSecurityConfig
{
    @Autowired
    private UserBusinessService service;
    
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception
    {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/", "/home", "/register", "register/doRegister", "/images/**", "/error")
                        .permitAll()
                        .requestMatchers("/service/**","/products/**")
                        .authenticated()
                        .anyRequest())
                .formLogin(form -> form
                        .loginPage("/login")
                        .usernameParameter("username")
                        .passwordParameter("password")
                        .permitAll()
                        .defaultSuccessUrl("/products/display", true))
                .logout(lo -> lo
                        .logoutUrl("/logout")
                        .invalidateHttpSession(true)
                        .clearAuthentication(true)
                        .permitAll()
                        .logoutSuccessUrl("/"))
                .httpBasic(Customizer.withDefaults())
        ;

        return http.build();
    }


    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
            .userDetailsService(service)
            .passwordEncoder(passwordEncoder);
    }
}
