package com.cifojava.libraryexercise.Model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

//AUTHOR ENTITY CLASS
@Entity
@Table(name = "AUTHORS")
@Getter @Setter @NoArgsConstructor @ToString
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String name;

    private String lastName;

    //Here we define a relationship 1-n with books. So one author can have many books.
    //We also define "in this case" that we do not want to show the books stored in Author when we parse it to JSON.
    //So JSONIGNORE annotation helps us resolve the infinite recursion problem.
    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Book> books = new ArrayList<>();

    //Same from above but with QUOTE class...
    @OneToMany(mappedBy = "author")
    @JsonIgnore
    private List<Quote> quotes= new ArrayList<>();

    public Author(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o)
            return true;
        if (!(o instanceof Author))
            return false;
        Author author = (Author) o;
        return Objects.equals(this.id, author.id) && Objects.equals(this.name, author.name)
                && Objects.equals(this.lastName, author.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.name, this.lastName);
    }


}
