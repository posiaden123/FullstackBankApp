package org.posiaden.bank.dao;

import org.posiaden.bank.entity.Account;
import org.springframework.security.core.userdetails.UserDetails;

//Interface for Spring account DAO setup
public interface AccountDAO {
    UserDetails findByUsername(String user);
    void save(Account account);
    Account getFromUser(String user);
    void addBalance(Float balance, Account account);
}
