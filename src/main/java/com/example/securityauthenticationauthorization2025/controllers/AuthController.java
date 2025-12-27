package com.example.securityauthenticationauthorization2025.controllers;

import com.example.securityauthenticationauthorization2025.dtos.LoginRequestDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {

    @GetMapping("/login")
    public String login(Model model) {

        model.addAttribute("user", new LoginRequestDto());
        return "auth/login";
    }
}
