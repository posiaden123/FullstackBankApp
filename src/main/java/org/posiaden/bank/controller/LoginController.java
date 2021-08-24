package org.posiaden.bank.controller;

import org.posiaden.bank.auth.AccountDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class LoginController {

    @GetMapping("/signup")
    public String signUp(Model model) {
        model.addAttribute("account",new AccountDTO());
        return "signup";
    }

    @GetMapping("/signin")
    public String login() {return "login";}
}
