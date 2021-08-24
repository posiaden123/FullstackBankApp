package org.posiaden.bank.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.posiaden.bank.entity.Account;
import org.posiaden.bank.entity.Authority;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

@Repository
public class RoleDAOImpl implements RoleDAO{

    @Autowired
    private SessionFactory factory;

    @Autowired
    @Lazy
    private AccountDAO accountDAO;

    @Override
    public Authority getAuthFromUser(String user) {
        Session session = factory.getCurrentSession();
        Account acc = accountDAO.getFromUser(user);
        return session.createQuery("from Authority where userName=:user",Authority.class)
                .setParameter("user",acc)
                .getSingleResult();
    }
}
