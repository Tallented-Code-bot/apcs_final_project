package com.calvin.bank_server;

// import java.net.http.HttpHeaders;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class FileController {

    private final UserRepository repository;
    private Logger logger = LoggerFactory.getLogger(FileController.class);

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

    // @PostMapping("/signup")
    @PostMapping(value="/signup", headers="Accept=application/x-www-form-urlencoded"
    /*produces=MediaType.APPLICATION_JSON_VALUE*/)
    public ResponseEntity<String> signup(BankUser user) {

        logger.info("Creating new user " + user);
        repository.save(new BankUser(user.getUsername(),encoder.encode(user.getPassword()),"ROLE_USER"));


        HttpHeaders headers = new HttpHeaders();
        headers.add("Location","/login");

        return new ResponseEntity<String>(headers,HttpStatus.FOUND);

    }

    @PostMapping("/users/{id}/deposit")
    public ResponseEntity<String> deposit(@PathVariable(value = "id") long id,
            @RequestParam(value = "withdraw_deposit") String withdraw_deposit,
            @RequestParam(value = "amount") int amount,
            HttpServletRequest request) {
        BankUser user = repository.getReferenceById(id);

        if (user != null) {
            switch (withdraw_deposit) {
                case "Withdraw":
                    if (amount > user.getDollars()) {
                        // cannot withdraw more than you have
                        return ResponseEntity.status(422).body("Cannot withdraw more than you have");
                    }
                    user.setDollars(user.getDollars() - amount);
                    break;
                case "Deposit":
                    user.setDollars(user.getDollars() + amount);
                    break;
            }

            repository.save(user);
        }

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location","/users/"+id);

        return new ResponseEntity<String>(headers,HttpStatus.FOUND);

        // return ResponseEntity.status(302).body("/users/" + id);
        // return ResponseEntity.ok().build();
    }

}
