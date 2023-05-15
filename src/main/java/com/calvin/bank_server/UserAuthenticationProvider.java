package com.calvin.bank_server;

import org.springframework.security.core.Authentication;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;


@Component
public class UserAuthenticationProvider implements AuthenticationProvider {
    private UserRepository repository;
    private PasswordEncoder encoder;
    Logger logger = LoggerFactory.getLogger(UserAuthenticationProvider.class); 

    public UserAuthenticationProvider(UserRepository repository, PasswordEncoder passwordEncoder){
        this.repository = repository;
        this.encoder = passwordEncoder;
    }


    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();

        BankUser user = repository.findByUsername(username);
        if(user == null){
            throw new BadCredentialsException("User not found");
        }
        
        if( encoder.matches(password,user.getPassword())){
            logger.info("Successfully authenticated user.");
            return new UsernamePasswordAuthenticationToken(username,password,getUserRoles(user.getRole()));
        }else{
            throw new BadCredentialsException("Password mismatch");
        }
    }





    private List<GrantedAuthority> getUserRoles(String userRoles){
        List<GrantedAuthority> roleList = new ArrayList<>(); 
        String[] roles = userRoles.split(",");
        for(String role: roles){
            roleList.add(new SimpleGrantedAuthority(role.replaceAll("\\s+","")));
        }
        return roleList;
    }


    @Override
    public boolean supports(Class<?> authentication){
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
