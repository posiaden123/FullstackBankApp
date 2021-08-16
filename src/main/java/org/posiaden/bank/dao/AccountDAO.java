package org.posiaden.bank.dao;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

public interface AccountDAO {
    UserDetails findByUsername(String user);
}
