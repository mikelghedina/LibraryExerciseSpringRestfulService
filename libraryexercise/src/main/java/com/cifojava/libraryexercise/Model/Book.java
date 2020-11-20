package com.cifojava.libraryexercise.Model;


import com.fasterxml.jackson.annotation.*;
import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Data
@Entity
@Table(name = "BOOKS")
@Getter @Setter @NoArgsConstructor @ToString
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;
    private String ISBN;
    private int pages;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "author_id")
    private Author author;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "registry_id")
    private Registry registry;

    public Book(String title, String ISBN, int pages) {
        this.title = title;
        this.ISBN = ISBN;
        this.pages = pages;
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
