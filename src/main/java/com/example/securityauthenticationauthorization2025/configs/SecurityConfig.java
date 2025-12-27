package com.example.securityauthenticationauthorization2025.configs;

import com.example.securityauthenticationauthorization2025.entities.Role;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeHttpRequests(
                configurer ->
                        configurer.requestMatchers("/assets/**", "/js/**", "/css/**", "/images/**").permitAll()
                                .requestMatchers("/").permitAll()
                                .requestMatchers("/login","/register").anonymous()
                                .requestMatchers("/manager").hasAnyRole(Role.ADMIN.name(), Role.MANAGER.name())
                                .requestMatchers("/admin").hasRole(Role.ADMIN.name())
                                .anyRequest().authenticated()
        ).formLogin(formLogin ->
                formLogin.loginPage("/login") // cilen faqe GET endpoint me perdore
                        .loginProcessingUrl("/login") // post endpoint me perdore ->
                        .defaultSuccessUrl("/", true)
        ).logout(LogoutConfigurer::permitAll)
                .exceptionHandling(exception ->
                        exception.accessDeniedPage("/403")
                );
        return httpSecurity.build();
    }


}
