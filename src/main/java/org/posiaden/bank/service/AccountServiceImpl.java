package org.posiaden.bank.service;

import org.posiaden.bank.dao.AccountDAO;
import org.posiaden.bank.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountDAO dao;


    @Override
    @Transactional
    public void save(Account account) {
        dao.save(account);
    }

    @Override
    @Transactional
    public Account getAccountFromUser(String user) {
        System.out.println(user);
        return dao.getFromUser(user);
    }
}
