package com.cifojava.libraryexercise.Model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter @NoArgsConstructor
public class Quote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String quote;

    //@ManyToOne
    //@JoinColumn(name = "Author_ID")
    //private Author author;


    public Quote(int id, String quote) {
        this.id = id;
        this.quote = quote;
    }
}
