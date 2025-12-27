package com.example.securityauthenticationauthorization2025.configs;

import com.example.securityauthenticationauthorization2025.entities.Role;
import com.example.securityauthenticationauthorization2025.entities.UserEntity;
import com.example.securityauthenticationauthorization2025.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;

@Configuration
@RequiredArgsConstructor
public class DataInitialization {

    @Bean
    public CommandLineRunner commandLineRunner(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            if (userRepository.count() == 0) {
                // krijo nje admin account edhe nje manager account
                UserEntity user1 = UserEntity.builder()
                        .name("Naim")
                        .surname("Sulejmani")
                        .username("naimsulejmani")
                        .email("naim.sulejmani@gmail.com")
                        .password(passwordEncoder.encode("123456"))
                        .role(Role.ADMIN)
                        .createdAt(LocalDateTime.now())
                        .build();
                userRepository.save(user1);

                UserEntity user2 = UserEntity.builder()
                        .name("Menaxher")
                        .surname("Menaxheri")
                        .username("manager")
                        .email("manager@manager.com")
                        .password(passwordEncoder.encode("123456"))
                        .role(Role.MANAGER)
                        .createdAt(LocalDateTime.now())
                        .build();
                userRepository.save(user2);
            }
        };
    }

}
