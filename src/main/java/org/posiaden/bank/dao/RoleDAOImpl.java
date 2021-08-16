package org.posiaden.bank.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.posiaden.bank.entity.Authority;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RoleDAOImpl implements RoleDAO{

    @Autowired
    private SessionFactory factory;

    @Override
    public Authority getAuthFromUser(String user) {
        Session session = factory.getCurrentSession();
        return session.createQuery("from Authority where userName=:user",Authority.class)
                .setParameter("user",user)
                .getSingleResult();
    }
}
