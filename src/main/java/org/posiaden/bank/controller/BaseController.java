package org.posiaden.bank.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class BaseController {

    @RequestMapping("/")
    public String redirect() {
        return "redirect:/home";
    }
    @RequestMapping("/home")
    public String landing() {
        return "landing-page";
    }
}
