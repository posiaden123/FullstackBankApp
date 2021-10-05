package org.posiaden.bank.controller;

import org.posiaden.bank.auth.AccountDTO;
import org.posiaden.bank.entity.Account;
import org.posiaden.bank.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

//Validation for creating an account, backend setup of new account
@Controller
@RequestMapping("/signup")
public class RegisterController {

    @Autowired
    private AccountService accountService;

    //Init string trimmer for validation
    @InitBinder
    public void init(WebDataBinder binder) {
        StringTrimmerEditor trimmer = new StringTrimmerEditor(true);
        binder.registerCustomEditor(String.class,trimmer);
    }

    //Setup account and save it to the database
    @PostMapping("/auth")
    public String auth(@Valid @ModelAttribute("account")AccountDTO transfer, BindingResult br) {
        if (br.hasErrors()) {
            return "signup";
        }
        Account account = new Account();
        account.setEmail(transfer.getEmail());
        account.setFirstName(transfer.getFirstName());
        account.setLastName(transfer.getLastName());
        account.setPassword(transfer.getPassword());
        account.setUsername(transfer.getUsername());
        accountService.save(account);
        return "redirect:/home";
    }
}
