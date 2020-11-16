package com.cifojava.libraryexercise.Model;


import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;


@Data
@Entity
@Table(name = "AUTHORS")
@Getter @Setter @NoArgsConstructor @ToString
public class Author {

    @Id
    @GeneratedValue
    private Long id;

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

    //@OneToMany(mappedBy = "Author", cascade = CascadeType.ALL)
    //private List<Book> books = new ArrayList<Book>();

    //@OneToMany(mappedBy = "Author", cascade = CascadeType.ALL)
    //private List<Quote> quotes = new ArrayList<Quote>();

}
