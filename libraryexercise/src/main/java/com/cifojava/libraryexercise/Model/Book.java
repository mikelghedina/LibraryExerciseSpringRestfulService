package com.cifojava.libraryexercise.Model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "BOOKS")
@Getter @Setter @NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue
    private int id;

    private String title;
    private String ISBN;
    private int pages;

    public Book(String title, String ISBN, int pages) {
        this.title = title;
        this.ISBN = ISBN;
        this.pages = pages;
    }

    public Book(String title){
        this.title = title;
    }

}
