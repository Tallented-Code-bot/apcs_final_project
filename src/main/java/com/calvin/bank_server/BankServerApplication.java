package com.calvin.bank_server;

//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication
//public class BankServerApplication {

	//public static void main(String[] args) {
		//SpringApplication.run(BankServerApplication.class, args);
	//}

//}




import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ui.Model;

@SpringBootApplication
//@RestController
public class BankServerApplication {
    public static void main(String[] args) {
      // SpringApplication.run(BankServerApplication.class, args);
      SpringApplication.run(BankServerApplication.class, args);
    }
    // @GetMapping("/hello")
    // public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
    //   return String.format("Hello %s!", name);
    // }

    //@GetMapping("/")
    //public String index(Model model){
    //  return "index";
    //}
}
