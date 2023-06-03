package com.calvin.bank_server;

import java.nio.file.attribute.UserPrincipal;
import java.security.Principal;
import java.util.List;
import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

// @Configuration
@Controller
public class MvcConfig /* implements WebMvcConfigurer */ {
    // public void addViewControllers(ViewControllerRegistry registry) {
    // registry.addViewController("/").setViewName("index");
    // registry.addViewController("/login").setViewName("login");
    // registry.addViewController("/signup").setViewName("signup");
    // registry.addViewController("/balance").setViewName("balance");
    // registry.addViewController("/admin").setViewName("admin");
    // }


    private UserRepository repository;


    public MvcConfig(UserRepository repository){
        this.repository = repository;
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/signup")
    public String signup() {
        return "signup";
    }

    @GetMapping("/balance")
    public String balance(ModelMap model, Principal principal) {
        String name = principal.getName();
        

        BankUser u = repository.findByUsername(name);
        double balance = u.getDollars();
        String role = u.getRole();


        model.addAttribute("username", name);
        model.addAttribute("balance", balance);
        model.addAttribute("role",role);
        return "balance";
    }

    @GetMapping("/admin")
    public String admin() {
        return "admin";
    }


    @GetMapping("/teller")
    public String teller(){
        return "teller";
    }


    @GetMapping("/teller/search")
    public String tellerUser(@RequestParam(value="username") String username, ModelMap model){
        List<BankUser> users = repository.findAll();
        System.out.println("The user array is " + users);
        model.addAttribute("users",users);

        return "tellerUser";
    }




    @GetMapping("/users/{id}")
    public String user(@PathVariable(value="id") long id, ModelMap model){
        // Optional<BankUser> user = repository.findById(id);
        BankUser user = repository.findById(id).orElse(null);



        model.addAttribute("user",user);

        return "user";
    }    
    
}
