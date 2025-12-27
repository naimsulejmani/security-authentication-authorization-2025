package com.example.securityauthenticationauthorization2025.services.impls;

import com.example.securityauthenticationauthorization2025.dtos.UserRegistrationDto;
import com.example.securityauthenticationauthorization2025.entities.UserEntity;
import com.example.securityauthenticationauthorization2025.exceptions.UserExistException;
import com.example.securityauthenticationauthorization2025.repositories.UserRepository;
import com.example.securityauthenticationauthorization2025.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserEntity loadByUsername(String username) {

        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

    @Override
    public UserEntity loadByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

    @Override
    public UserEntity register(UserRegistrationDto dto) {

        if (userRepository.findByUsername(dto.getUsername()).isPresent()) {
            throw new UserExistException("User already exists");
        }
        if (userRepository.findByEmail(dto.getEmail()).isPresent()) {
            throw new UserExistException("User already exists");
        }

        UserEntity userEntity = UserEntity.builder()
                .name(dto.getName())
                .surname(dto.getSurname())
                .password(passwordEncoder.encode(dto.getPassword()))
                .createdAt(LocalDateTime.now())
                .role(dto.getRole())
                .username(dto.getUsername())
                .email(dto.getEmail())
                .build();

        userRepository.save(userEntity);


        return userEntity;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = loadByUsername(username);
        UserDetails userDetails = User.withUsername(user.getUsername())
                .password(user.getPassword())
                .roles(user.getRole().name())
                .build();
        return userDetails;
    }
}
