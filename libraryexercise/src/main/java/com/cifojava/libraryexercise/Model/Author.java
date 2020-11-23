package com.cifojava.libraryexercise.Model;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Entity
@Table(name = "AUTHORS")
@Getter @Setter @NoArgsConstructor @ToString
@JsonIdentityInfo(
        generator = ObjectIdGenerators.IntSequenceGenerator.class,
        property = "id")
public class Author implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    //private String fullName;

    private String name;

    private String lastName;

    @OneToMany(mappedBy = "author",
            cascade = CascadeType.ALL)
    //@JsonIgnoreProperties("books")
    private List<Book> books = new ArrayList<Book>();

    @OneToMany(mappedBy = "author",
            cascade = CascadeType.ALL)
    //@JsonIgnoreProperties("quotes")
    private List<Quote> quotes= new ArrayList<Quote>();

    public Author(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
        //this.fullName = name+ " " + lastName;
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
