package org.posiaden.bank.controller;

import org.posiaden.bank.auth.AccountDTO;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/signup")
public class RegisterController {

    @InitBinder
    public void init(WebDataBinder binder) {
        StringTrimmerEditor trimmer = new StringTrimmerEditor(true);
        binder.registerCustomEditor(String.class,trimmer);
    }

    @PostMapping("/auth")
    public String auth(@Valid @ModelAttribute("account")AccountDTO transfer, BindingResult br) {
        if (br.hasErrors()) {
            return "signup";
        }

        return "redirect:/home";
    }
}
