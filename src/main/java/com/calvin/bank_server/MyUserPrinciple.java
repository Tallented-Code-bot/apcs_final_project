package com.calvin.bank_server;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class MyUserPrinciple implements UserDetails{
    private BankUser user;

    public MyUserPrinciple(BankUser user){
        this.user=user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.<GrantedAuthority>singletonList(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        // accounts do not expire
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        // accounts cannot be locked
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // credentials do not expire
        return true;
    }

    @Override
    public boolean isEnabled() {
        // always enabled
        return true;
    }
}