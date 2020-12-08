package com.cifojava.libraryexercise.Model;

import lombok.*;

import javax.persistence.*;

import java.util.Objects;


@Entity
@Table(name = "QUOTES")
@Getter @Setter @NoArgsConstructor @ToString
public class Quote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    @ManyToOne
    @JoinColumn(name = "author_id", nullable = true)
    private Author author;

    public Quote(String content) {
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Quote quote = (Quote) o;
        return Objects.equals(id, quote.id) &&
                Objects.equals(content, quote.content) &&
                Objects.equals(author, quote.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, content, author);
    }
}
