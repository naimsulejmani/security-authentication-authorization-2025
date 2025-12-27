package com.example.securityauthenticationauthorization2025.controllers;

import com.example.securityauthenticationauthorization2025.dtos.LoginRequestDto;
import com.example.securityauthenticationauthorization2025.dtos.UserRegistrationDto;
import com.example.securityauthenticationauthorization2025.exceptions.UserExistException;
import com.example.securityauthenticationauthorization2025.services.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    @GetMapping("/login")
    public String login(Model model) {

        model.addAttribute("user", new LoginRequestDto());
        return "auth/login";
    }

    @GetMapping("/register")
    public String getRegister(Model model) {
        model.addAttribute("register", new UserRegistrationDto());
        return "auth/register";
    }

    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("register") UserRegistrationDto register,
                           BindingResult bindingResult, Model model,
                           RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "auth/register";
        }
        try {
            userService.register(register);
            redirectAttributes.addAttribute("registrationMessage","User registered successfully");
            return "redirect:/login";
        } catch (UserExistException e) {
            bindingResult.rejectValue("username", "error.userExist", e.getMessage());
            model.addAttribute("registerError", e.getMessage());
            return "auth/register";
        }
    }
}
