package com.cifojava.libraryexercise.Model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "USERS")
@Getter @Setter @NoArgsConstructor
public class User {

    private @Id Long id;

    private String username;
    private String password;
    private int age;


    public User(String username, String password, int age) {
        this.username = username;
        this.password = password;
        this.age = age;
    }
    public User() {

    }
}
