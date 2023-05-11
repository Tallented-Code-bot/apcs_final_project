package com.calvin.bank_server;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class BankUser {
    private @Id @GeneratedValue Long id;
    private String name;
    private String password;

    BankUser() {
    }

    BankUser(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof BankUser)) {
            return false;
        }
        BankUser u = (BankUser) o;
        return Objects.equals(this.id, u.id) && Objects.equals(this.name, u.name)
                && Objects.equals(this.password, u.password);
    }


    @Override
    public int hashCode(){
        return Objects.hash(this.id, this.name, this.password);
    }

    @Override
    public String toString(){
        return "User{id=" +this.id +", name=\"" + this.name + "\", password=\"" + this.password +"\"}";
    }
}
