package com.cifojava.libraryexercise.Model;



import lombok.*;
import org.hibernate.annotations.CreationTimestamp;


import javax.persistence.*;


import java.util.ArrayList;
import java.util.Date;
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
    private List<Book> books = new ArrayList<>();

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
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
