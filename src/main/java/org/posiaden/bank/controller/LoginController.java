package org.posiaden.bank.controller;

import org.posiaden.bank.auth.AccountDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

//Controller for account pages
@Controller
@RequestMapping("/")
public class LoginController {

    //Create account object for transfer and send it to form
    @GetMapping("/signup")
    public String signUp(Model model) {
        model.addAttribute("account",new AccountDTO());
        return "signup";
    }

    //Path to login form
    @GetMapping("/signin")
    public String login() {return "login";}
}
