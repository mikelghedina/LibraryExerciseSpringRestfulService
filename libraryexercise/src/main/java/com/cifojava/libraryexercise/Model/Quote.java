package com.cifojava.libraryexercise.Model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

@Entity
@Getter @Setter @NoArgsConstructor
public class Quote {

    @Id
    private int id;
    @JoinColumn(name = "authors")
    private String quote;

}
