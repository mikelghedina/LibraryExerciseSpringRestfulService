package com.cifojava.libraryexercise.Model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Table(name = "AUTHORS")
@Getter @Setter @NoArgsConstructor
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String fullName;

    @OneToMany
    private ArrayList<Book> books;

    @OneToMany(mappedBy = "authors", cascade = CascadeType.ALL)
    private ArrayList<Quote> quotes;



}
