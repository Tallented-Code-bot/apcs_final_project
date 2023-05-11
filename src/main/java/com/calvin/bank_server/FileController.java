package com.calvin.bank_server;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FileController {

    private final UserRepository repository;

    FileController(UserRepository repository) {
        this.repository = repository;
    }


    @PostMapping("/newuser")
    BankUser newUser(@RequestBody BankUser newUser){
        return repository.save(newUser);
    }


    @GetMapping("/allusers")
    List<BankUser> allUsers(){
        return repository.findAll();
    }





}
