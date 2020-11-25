package com.cifojava.libraryexercise.Model.Dto;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter @Setter @NoArgsConstructor
public class BookDto {

    private Long id;
    private String title;
    private String isbn;
    private int pages;
    private String authorName;
    private String authorLastName;

}