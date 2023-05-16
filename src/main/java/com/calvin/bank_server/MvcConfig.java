package com.calvin.bank_server;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

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

        model.addAttribute("username", name);
        System.out.println(name);
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
}
