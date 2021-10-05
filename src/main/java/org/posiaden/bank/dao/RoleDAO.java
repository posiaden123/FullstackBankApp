package org.posiaden.bank.dao;

import org.posiaden.bank.entity.Authority;

//DAO object for Roles of a user
public interface RoleDAO {
    Authority getAuthFromUser(String user);
}
