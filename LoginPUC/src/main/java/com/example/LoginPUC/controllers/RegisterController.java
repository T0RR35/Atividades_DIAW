package com.example.LoginPUC.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;

@Controller
public class RegisterController {
    @GetMapping("/register")
    public String register(){
        return "register";
    }

}
