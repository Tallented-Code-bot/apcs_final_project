package com.calvin.bank_server;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Configuration
public class LoadUserRepository {
    private static final Logger log = LoggerFactory.getLogger(LoadUserRepository.class);
    private PasswordEncoder encoder = new BCryptPasswordEncoder();
        


    @Bean
    CommandLineRunner initDatabase(UserRepository repository){
        return args -> {
            log.info("Preloading " + repository.save(new BankUser("admin",encoder.encode("admin"),"ROLE_ADMIN")));
            log.info("Preloading "+repository.save(new BankUser("user",encoder.encode("password"),"ROLE_USER",84.0)));
            log.info("Preloading "+repository.save(new BankUser("teller",encoder.encode("teller"),"ROLE_TELLER")));
        };
    }
}
