package com.example.demo.controller;

import com.example.demo.model.Permision;
import com.example.demo.model.Role;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //super.configure(http);
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/").permitAll()
                //.antMatchers(HttpMethod.GET, "/client/**").hasAnyRole(Role.USER.name(), Role.ADMIN.name())
                // .antMatchers(HttpMethod.POST, "/client/**").hasRole(Role.ADMIN.name())
                // .antMatchers(HttpMethod.DELETE, "/client/**").hasRole(Role.ADMIN.name())
                //.antMatchers(HttpMethod.GET, "/client/**").hasAuthority(Permision.READING.getPermission())
               // .antMatchers(HttpMethod.POST, "/client/**").hasAuthority(Permision.WRITTING.getPermission())
               // .antMatchers(HttpMethod.DELETE, "/client/**").hasAuthority(Permision.WRITTING.getPermission())
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();

    }

    @Bean
    @Override
    protected UserDetailsService userDetailsService() {
        return new InMemoryUserDetailsManager(
                User.builder()
                        .username("admin")
                        .password(passwordEncoder().encode("admin"))
                        //.roles(Role.ADMIN.name())
                        .authorities(Role.ADMIN.getAuthorities())
                .build(),
                User.builder()
                .username("user")
                .password(passwordEncoder().encode("user"))
                //.roles(Role.USER.name())
                .authorities(Role.USER.getAuthorities())
                .build()

        );

    }

    @Bean
    protected PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(12);
    }
}
