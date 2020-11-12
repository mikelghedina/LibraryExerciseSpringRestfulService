package com.cifojava.libraryexercise.Model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table (name = "USERS")
@Getter @Setter @NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
    private int age;

    //@ManyToOne
    //@JoinColumn(name = "AUTHOR_ID")
    //private Author author;

    public User(String username, String password, int age) {
        this.username = username;
        this.password = password;
        this.age = age;
    }

}
