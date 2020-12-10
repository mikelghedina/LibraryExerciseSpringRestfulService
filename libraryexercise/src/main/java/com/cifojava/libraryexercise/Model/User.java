package com.cifojava.libraryexercise.Model;


import com.fasterxml.jackson.annotation.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

//USER ENTITY CLASS
@Entity
@Table (name = "USERS")
@Getter @Setter @NoArgsConstructor @ToString
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
    private int age;

    //Using JsonIgnore because we won't be using the registries data when calling users from API.
    //So one more time we solve the infinite recursion problem when accessing data from API REQUEST METHODS.
    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<Registry> registries= new ArrayList<>();

    public User(String username, String password, int age) {
        this.username = username;
        this.password = password;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age &&
                Objects.equals(id, user.id) &&
                Objects.equals(username, user.username) &&
                Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, age);
    }
}
