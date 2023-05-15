package com.calvin.bank_server;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class BankUser {
    private @Id @GeneratedValue Long id;
    private String username;
    private String password;
    private String role;

    /** The balance of the user, in cents. */
    private long balance;

    BankUser() {
    }

    BankUser(String name, String password) {
        this.username = name;
        this.password = password;
        this.role = "ROLE_USER";
        this.balance = 0;
    }

    BankUser(String name, String password, String role){
        this.username = name;
        this.password = password;
        this.role = role;
        this.balance = 0;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Long getId() {
        return id;
    }

    public String getRole() {
        return role;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String name) {
        this.username = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setCents(long cents){
        this.balance = cents;
    }

    public long getCents() {
        return balance;
    }

    public double getDollars(){
        return (double) balance / 100;
    }

    public void setDollars(double dollars){
        this.balance = (long) (dollars * 100);
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
        return Objects.equals(this.id, u.id) && Objects.equals(this.username, u.username)
                && Objects.equals(this.password, u.password) && Objects.equals(this.role,u.role);
    }


    @Override
    public int hashCode(){
        return Objects.hash(this.id, this.username, this.password, this.role);
    }

    @Override
    public String toString(){
        return "User{id=" +this.id +", name=\"" + this.username + "\", password=\"" + this.password + ", role = \"" + role +"\"}";
    }
}
