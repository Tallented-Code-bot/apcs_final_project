package com.calvin.bank_server;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<BankUser,Long>{
    BankUser findByUsername(String name);
}
