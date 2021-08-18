package org.posiaden.bank.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class LoginController {

    @GetMapping("/signup")
    public String signUp() {
        return "signup";
    }

    @GetMapping("/signin")
    public String login() {return "login";}
}
