package com.calvin.bank_server;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class User {
    private long id;
    private String name;    
    private String password;
}
