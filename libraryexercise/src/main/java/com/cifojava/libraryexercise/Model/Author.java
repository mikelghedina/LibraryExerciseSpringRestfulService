package com.cifojava.libraryexercise.Model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "AUTHORS")
@Getter @Setter @NoArgsConstructor
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String fullName;

    //@OneToMany(mappedBy = "Author", cascade = CascadeType.ALL)
    //private List<Book> books = new ArrayList<Book>();

    //@OneToMany(mappedBy = "Author", cascade = CascadeType.ALL)
    //private List<Quote> quotes = new ArrayList<Quote>();

}
