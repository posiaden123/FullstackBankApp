package org.posiaden.bank.service;

import org.posiaden.bank.entity.Account;

//Spring service layer for accounts
public interface AccountService {
    void save(Account account);
    Account getAccountFromUser(String user);
    void addBal(Float balance, Account account);
}
