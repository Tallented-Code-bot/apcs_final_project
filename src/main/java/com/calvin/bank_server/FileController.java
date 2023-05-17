package com.calvin.bank_server;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FileController {

    private final UserRepository repository;

    private PasswordEncoder encoder;

    FileController(UserRepository repository, PasswordEncoder encoder) {
        this.repository = repository;
        this.encoder = encoder;
    }

    @PostMapping("/newuser")
    BankUser newUser(@RequestBody BankUser newUser) {
        return repository.save(newUser);
    }

    @GetMapping("/allusers")
    List<BankUser> allUsers() {
        return repository.findAll();
    }

    @PostMapping("/signup")
    public BankUser signup(@RequestBody BankUser user){
        BankUser u = new BankUser();

        u.setUsername(user.getUsername());
        u.setPassword(encoder.encode(user.getPassword()));
        u.setRole("ROLE_USER");
        return repository.save(u);
    }



    @PostMapping("/users/{id}/deposit")
    public void deposit(@PathVariable(value="id") long id, @RequestParam(value="withdraw_deposit") String withdraw_deposit,@RequestParam(value="amount") int amount){
        BankUser user = repository.getReferenceById(id);



        if(user != null){
            switch(withdraw_deposit) {
                case "Withdraw":  
                case "Deposit": 
            }
        }
    }

}
