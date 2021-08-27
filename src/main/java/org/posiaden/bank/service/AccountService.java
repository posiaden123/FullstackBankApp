package org.posiaden.bank.service;

import org.posiaden.bank.entity.Account;

public interface AccountService {
    void save(Account account);
    Account getAccountFromUser(String user);
}
