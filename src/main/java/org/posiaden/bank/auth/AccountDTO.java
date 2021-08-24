package org.posiaden.bank.auth;


import org.posiaden.bank.annotation.Name;
import org.posiaden.bank.annotation.Password;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class AccountDTO {
    public AccountDTO(){}

    @NotNull(message = "field is required")
    @Size(min = 1,message = "field is required")
    @Name
    private String firstName;

    @NotNull(message = "field is required")
    @Size(min = 1,message = "field is required")
    @Name
    private String lastName;

    @NotNull(message = "field is required")
    @Size(min = 8,message = "password must be 8 characters or longer")
    @Password
    private String password;

    @NotNull(message = "field is required")
    @Size(min = 1,message = "field is required")
    @Email(message = "input a proper email!")
    private String email;

    @NotNull(message = "field is required")
    @Size(min = 1,message = "field is required")
    private String username;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
