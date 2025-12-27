package com.example.securityauthenticationauthorization2025.services;

import com.example.securityauthenticationauthorization2025.dtos.UserRegistrationDto;
import com.example.securityauthenticationauthorization2025.entities.UserEntity;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    UserEntity loadByUsername(String username);

    UserEntity loadByEmail(String email);

    public UserEntity register(UserRegistrationDto userRegistrationDto);
}
