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

    //Closing relationship with USER class. We do need to use the user data when parsed in Json
    //So we won't be using JsonIgnore annotation here.
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    //Mapping the relationship with books
    //No JsonIgnore so we need to see the books related to registry object when parsed to Json.
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
