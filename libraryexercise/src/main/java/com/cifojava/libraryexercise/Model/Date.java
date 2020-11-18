package com.cifojava.libraryexercise.Model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Data
@Entity
@Table(name="DATE")
@Getter @Setter @NoArgsConstructor @ToString
public class Date {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int day;
    private int month;
    private int year;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "registry_id")
    @JsonIgnore
    private Registry registry;

    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Date date = (Date) o;
        return day == date.day &&
                month == date.month &&
                year == date.year &&
                Objects.equals(id, date.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, day, month, year);
    }
}
