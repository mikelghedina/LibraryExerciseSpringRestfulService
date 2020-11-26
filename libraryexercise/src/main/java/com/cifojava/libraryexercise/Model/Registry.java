package com.cifojava.libraryexercise.Model;


import com.fasterxml.jackson.annotation.*;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Table(name = "REGISTRY")
@Getter @Setter @NoArgsConstructor @ToString
@Entity
public class Registry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "registry")
    @JsonIgnore
    private List<Book> books = new ArrayList<>();

    @OneToOne(mappedBy = "registry")
    @JsonIgnore
    private Date date;



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Registry registry = (Registry) o;
        return Objects.equals(id, registry.id) &&
                Objects.equals(user, registry.user) &&
                Objects.equals(books, registry.books);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, books);
    }
}
