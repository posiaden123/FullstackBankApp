package org.posiaden.bank.service;

import org.posiaden.bank.dao.AccountDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    @Lazy
    private AccountDAO accountDAO;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserDetails user = accountDAO.findByUsername(s);
        if (user == null) {
            throw new UsernameNotFoundException(s);
        }
        return user;
    }


}
