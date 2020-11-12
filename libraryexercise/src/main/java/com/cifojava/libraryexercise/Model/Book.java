package com.cifojava.libraryexercise.Model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "BOOKS")
@Getter @Setter @NoArgsConstructor @ToString
public class Book {

    @Id
    @GeneratedValue
    private Long id;

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

    @Override
    public boolean equals(Object o) {

        if (this == o)
            return true;
        if (!(o instanceof Book))
            return false;
        Book book = (Book) o;
        return Objects.equals(this.id, book.id) && Objects.equals(this.title, book.title)
                && Objects.equals(this.ISBN, book.ISBN);
    }
    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.title, this.ISBN,this.pages, this.author);
    }

}
