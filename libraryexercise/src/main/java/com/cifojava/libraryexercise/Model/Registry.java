package com.cifojava.libraryexercise.Model;


import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Data
@Table(name = "REGISTRY")
@Getter @Setter @NoArgsConstructor @ToString
@Entity
public class Registry {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;


    @OneToMany(mappedBy = "registry", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<Book> books ;

    public Registry(User user, List<Book> books) {
        this.user = user;
        this.books = books;
    }

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
