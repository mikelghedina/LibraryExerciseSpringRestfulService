package com.cifojava.libraryexercise.Model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "AUTHORS")
@Getter @Setter @NoArgsConstructor
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    //private String fullName;

    private String name;
    private String lastName;

    @OneToMany(mappedBy = "author", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<Book> books;

    public Author(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
        //this.fullName = name+ " " + lastName;

    }

    //@OneToMany(mappedBy = "Author", cascade = CascadeType.ALL)
    //private List<Book> books = new ArrayList<Book>();

    //@OneToMany(mappedBy = "Author", cascade = CascadeType.ALL)
    //private List<Quote> quotes = new ArrayList<Quote>();

}
