package org.posiaden.bank.dao;

import org.posiaden.bank.entity.Account;
import org.springframework.security.core.userdetails.UserDetails;

public interface AccountDAO {
    UserDetails findByUsername(String user);
    void save(Account account);
    Account getFromUser(String user);
}
