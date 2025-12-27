package com.example.securityauthenticationauthorization2025.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoginRequestDto {

    @NotNull(message = "Username is required")
    @NotBlank(message = "Username should not be empty or blank")
    @Size(min = 3, max = 50, message = "Username must be between 3 and 50 characters")
    private String username;

    @NotNull(message = "Password is required")
    @NotBlank(message = "Password should not be empty or blank")
    @Size(min = 6, max = 50, message = "Password must be between 6 and 50 characters")
    // pattern to have at least one uppercase, one lowercase, one digit and one special character
//    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{6,}$", message = "Password must have at least one uppercase, one lowercase, one digit and one special character")
    private String password;
}
