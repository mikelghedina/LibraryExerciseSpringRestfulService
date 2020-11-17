package com.cifojava.libraryexercise.Model;


import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "REGISTRY")
@Getter @Setter @NoArgsConstructor @ToString
public class Registry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "Registry", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<User> users;


    @OneToMany(mappedBy = "Registry", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<Book> books ;

    public Registry(List<User> users, List<Book> books) {
        this.users = users;
        this.books = books;
    }

}
