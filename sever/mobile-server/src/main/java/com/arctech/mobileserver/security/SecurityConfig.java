package com.arctech.mobileserver.security;

import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.authority.mapping.GrantedAuthoritiesMapper;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.SecurityFilterChain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
@EnableWebSecurity
@Configuration
public class SecurityConfig {

    @Value("${your.admin.email}") // Замените на свой конфигурационный способ
    private String adminEmail;

    @Value("${your.owner.emails}") // Замените на свой конфигурационный способ
    private List<String> mailsOfOwners;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/user/**").hasRole("USER")
                .antMatchers("/objects/**").hasRole("OBJECT")
                .anyRequest().authenticated()
                .and()
                .oauth2Login()
                .userInfoEndpoint().userService(oAuth2UserService());

        return http.build();
    }

    // не работает так как надо распредление ролей
    @Bean
    public OAuth2UserService<OAuth2UserRequest, OAuth2User> oAuth2UserService() {


        DefaultOAuth2UserService delegate = new DefaultOAuth2UserService();
        return (userRequest) -> {
            OAuth2User oAuth2User = delegate.loadUser(userRequest);
            String userEmail = oAuth2User.getAttribute("email");// Предположим, что email это атрибут, который приходит от провайдера
            System.out.println("----");
            System.out.println("name is : " + oAuth2User.getName());
            System.out.println("user email is : " + userEmail);
            Set<GrantedAuthority> mappedAuthorities = new HashSet<>();
            mappedAuthorities.add(new SimpleGrantedAuthority("ROLE_USER"));

            if (userEmail.equals(adminEmail)) {
                mappedAuthorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
            } else if (mailsOfOwners.contains(userEmail)) {
                mappedAuthorities.add(new SimpleGrantedAuthority("ROLE_OBJECT"));
            }

            return new DefaultOAuth2User(mappedAuthorities, oAuth2User.getAttributes(), "email");
        };
    }
}
