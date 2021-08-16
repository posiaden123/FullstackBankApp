package org.posiaden.bank.dao;

import org.posiaden.bank.entity.Authority;

public interface RoleDAO {
    Authority getAuthFromUser(String user);
}
