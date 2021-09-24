package org.posiaden.bank.controller;

import org.posiaden.bank.entity.Account;
import org.posiaden.bank.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class BaseController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/")
    public String redirect() {
        return "redirect:/home";
    }
    @GetMapping("/home")
    public String landing(Model model) {
        String details =  SecurityContextHolder.getContext().getAuthentication().getName();
        Account account = accountService.getAccountFromUser(details);
        model.addAttribute("balance",account.getBalance());
        return "landing-page";
    }
    @GetMapping("/deposit")
    public String deposit(Model model) {
        String details =  SecurityContextHolder.getContext().getAuthentication().getName();
        Account account = accountService.getAccountFromUser(details);
        model.addAttribute("account",account);
        return "deposit";
    }
    @PostMapping("/deposit/auth")
    public String confirm(@ModelAttribute("account") Account acc) {
        Float balance = acc.getBalance();
        String details =  SecurityContextHolder.getContext().getAuthentication().getName();
        Account account = accountService.getAccountFromUser(details);
        accountService.addBal(balance, account);
        return redirect();
    }
}
