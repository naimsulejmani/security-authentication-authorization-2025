package com.example.securityauthenticationauthorization2025.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/manager")
    public String manager() {
        return "manager";
    }

    @GetMapping("/admin")
    public String admin() {
        return "admin";
    }

    @GetMapping("/authenticated")
    public String authenticated() {
        return "authenticated";
    }

    @GetMapping("/403")
    public String accessDenied() {
        return "403";
    }
}
