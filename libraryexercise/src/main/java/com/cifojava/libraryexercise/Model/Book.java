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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;
    private String ISBN;
    private int pages;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "author_id", nullable = false)
    private Author author;

    public Book(String title, String ISBN, int pages, Author author) {
        this.title = title;
        this.ISBN = ISBN;
        this.pages = pages;
        this.author= author;
    }

    public Book(String title){
        this.title = title;
    }

}
