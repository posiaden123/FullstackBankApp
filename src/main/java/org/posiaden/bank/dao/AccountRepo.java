package org.posiaden.bank.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.posiaden.bank.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public class AccountRepo implements AccountDAO {

    @Autowired
    private SessionFactory factory;

    @Autowired
    private RoleDAO roleDAO;

    @Override
    public UserDetails findByUsername(String user) {
        Session session = factory.getCurrentSession();
        Query<Account> users = session.createQuery("from Account where username=:user", Account.class).setParameter("user",user);
        User.UserBuilder builder = User.builder();
        Account account = users.getSingleResult();
        builder.username(account.getUsername());
        builder.password(account.getPassword());
        builder.roles(roleDAO.getAuthFromUser(user).getRole());
        return builder.build();
    }
}
