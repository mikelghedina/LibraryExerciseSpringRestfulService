package com.cifojava.libraryexercise.Model;

import com.fasterxml.jackson.annotation.*;
import lombok.*;

import javax.persistence.*;
import java.util.Objects;

//BOOK ENTITY CLASS
@Entity
@Table(name = "BOOKS")
@Getter @Setter @NoArgsConstructor @ToString
public class Book{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String ISBN;
    private int pages;
    private String synopsis;


    //We close the relationship with author by the MANYTOONE annotation. nullable true by default.
    //Do not use JsonIgnore annotation here so we can visualize the AUTHOR related to Book.
    //We do not use Cascade so if we remove a book, the author related won't be deleted too.
    @ManyToOne
    @JoinColumn(name = "author_id", nullable = true)
    private Author author;

    //Closing relationship with Registry but using JsonIgnore here so we do not need to use
    //the data from Registry class. Then we solve the infinite recursion problem.
    @ManyToOne
    @JoinColumn(name = "registry_id", nullable = true)
    @JsonIgnore
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
