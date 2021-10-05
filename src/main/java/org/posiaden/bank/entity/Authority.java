package org.posiaden.bank.entity;

import javax.persistence.*;
import java.io.Serializable;

//JPA Entity for table "authorities"
@Table(name = "authorities")
@Entity
public class Authority implements Serializable {

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user", referencedColumnName = "user")
    @Id
    private Account userName;

    @Column(name = "role")
    private String role;

    public Account getUserName() {
        return userName;
    }

    public void setUserName(Account userName) {
        this.userName = userName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Authority(Account userName, String role) {
        this.userName = userName;
        this.role = role;
    }


    public Authority(){}
}