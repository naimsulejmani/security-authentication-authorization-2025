package com.example.securityauthenticationauthorization2025.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, nullable = false)
    private String name;

    @Column(length = 50, nullable = false)
    private String surname;

    @Column(length = 50, nullable = false, unique = true)
    private String username;

    @Column(length = 100, nullable = false, unique = true)
    private String email;

    @Column(length = 100, nullable = false)
    private String password;

    @Column(length = 20, nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role = Role.USER;


    @Column(nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();
    /*
    Kolonat tjera ndihmese si:
         - numbers of logins
         - last login date
         - isAccountNonExpired
         - isAccountNonLocked
         - isCredentialsNonExpired
         - isEnabled
         - isCredentialsExpired
         - passwordChangedAt
         - token
         - tokenExpirationDate
     */


}
