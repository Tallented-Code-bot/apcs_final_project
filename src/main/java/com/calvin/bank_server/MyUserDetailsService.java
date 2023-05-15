package com.calvin.bank_server;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService{
    @Autowired
    private UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String username){
        BankUser user = userRepository.findByUsername(username);
        if (user==null){
            throw new UsernameNotFoundException(username);
        }
        return new MyUserPrinciple(user);
    }


}


