package org.posiaden.bank.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.posiaden.bank.entity.Account;
import org.posiaden.bank.entity.Authority;
import org.posiaden.bank.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.logging.Logger;

@Repository
public class AccountRepo implements AccountDAO {
    private Logger logger;
    public AccountRepo(){
        logger = Logger.getLogger(getClass().getName());
    }
    @Autowired
    private SessionFactory factory;

    @Autowired
    @Lazy
    private RoleDAO roleDAO;

    @Autowired
    private PasswordEncoder encoder;

    @Override
    public UserDetails findByUsername(String user) {
        Session session = factory.getCurrentSession();
        Query<Account> users = session.createQuery("from Account where username=:user", Account.class).setParameter("user",user);
        User.UserBuilder builder = User.builder();
        Account account = users.getSingleResult();
        builder.username(account.getUsername());
        builder.password(account.getPassword());
        builder.roles(roleDAO.getAuthFromUser(user).getRole());
        logger.info(builder.toString());
        return builder.build();
    }

    @Override
    public void save(Account account) {
        Session session = factory.getCurrentSession();
        String encoded = encoder.encode(account.getPassword());
        account.setPassword(encoded);
        Authority auth = new Authority();
        auth.setUserName(account);
        auth.setRole(String.valueOf(Role.USER));
        session.save(account);
        session.save(auth);
    }

    @Override
    public Account getFromUser(String user) {
        Session session = factory.getCurrentSession();
        return session.createQuery("from Account where username=:user",Account.class).setParameter("user",user).getSingleResult();
    }
}
