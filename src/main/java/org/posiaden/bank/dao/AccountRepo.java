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

//Implementation of AccountDAO, does all account operations on database
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

    //Find an account based on user given
    @Override
    public UserDetails findByUsername(String user) {
        System.out.println(user);
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
    //Save an account given to database
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
    //Get an account object from a username given
    public Account getFromUser(String user) {
        Session session = factory.getCurrentSession();
        return session.createQuery("from Account where username=:user",Account.class).setParameter("user",user).getSingleResult();
    }

    @Override
    //Update balance of an account
    public void addBalance(Float balance, Account account) {
        Session session = factory.getCurrentSession();
        balance = balance + account.getBalance();
        session.createSQLQuery("update accounts set balance=:? where id=:o").setParameter("?",balance).setParameter("o",account.getId()).executeUpdate();
    }
}
