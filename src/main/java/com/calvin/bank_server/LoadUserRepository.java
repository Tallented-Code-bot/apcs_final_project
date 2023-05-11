package com.calvin.bank_server;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Configuration
public class LoadUserRepository {
    private static final Logger log = LoggerFactory.getLogger(LoadUserRepository.class);


    @Bean
    CommandLineRunner initDatabase(UserRepository repository){
        return args -> {
            log.info("Preloading " + repository.save(new BankUser("Calvin Tallent","test")));
            log.info("Preloading "+repository.save(new BankUser("Austin Tallent","another_test")));
        };
    }
}
