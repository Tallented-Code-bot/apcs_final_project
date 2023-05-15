package com.calvin.bank_server;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((req) -> req
                        .requestMatchers("/", "/home", "/index", "/signup","/allusers","/newuser")
                        .permitAll()/* .anyRequest().authenticated()*/)
                        
                // .formLogin(withDefaults())
                .formLogin((form) -> form
                        .loginPage("/login")
                        .permitAll())
                .logout((logout) -> logout.permitAll())
                .csrf().disable();
                

        return http.build();
    }


    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

//     @Bean
//     public UserDetailsService userDetailsService() {
//         UserDetails user = User.withDefaultPasswordEncoder()
//                 .username("calvin")
//                 .password("password")
//                 .roles("ROLE_USER")
//                 .build();

//         return new InMemoryUserDetailsManager(user);
//     }



//     public InternalResourceViewResolver internalResourceViewResolver(){
//         InternalResourceViewResolver resolver = new InternalResourceViewResolver();
//         resolver.setSuffix(".html");
//         resolver.setPrefix("");
//         // resolver.setPrefix("static/");
//         return resolver;
//     }

}
