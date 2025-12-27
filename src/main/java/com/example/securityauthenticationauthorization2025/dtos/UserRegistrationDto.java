package com.example.securityauthenticationauthorization2025.dtos;

import com.example.securityauthenticationauthorization2025.entities.Role;
import jakarta.validation.constraints.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRegistrationDto {

    @NotNull(message = "Name is required")
    @NotBlank(message = "Name should not be empty or blank")
    @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters")
    private String name;

    @NotNull(message = "Surname is required")
    @NotBlank(message = "Surname should not be empty or blank")
    @Size(min = 2, max = 50, message = "Surname must be between 2 and 50 characters")
    private String surname;

    @NotNull(message = "Username is required")
    @NotBlank(message = "Username should not be empty or blank")
    @Size(min = 3, max = 50, message = "Username must be between 3 and 50 characters")
    @Pattern(regexp = "^[a-zA-Z0-9_]+$", message = "Username must contain only letters, numbers and underscores")
    private String username;

    @NotNull(message = "Email is required")
    @NotBlank(message = "Email should not be empty or blank")
    @Email(message = "Email must be valid")
    private String email;

    @NotNull(message = "Password is required")
    @NotBlank(message = "Password should not be empty or blank")
    @Size(min = 6, max = 50, message = "Password must be between 6 and 50 characters")
//    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{6,}$", message = "Password must have at least one uppercase, one lowercase, one digit and one special character")
    private String password;

    private Role role = Role.USER;

}
