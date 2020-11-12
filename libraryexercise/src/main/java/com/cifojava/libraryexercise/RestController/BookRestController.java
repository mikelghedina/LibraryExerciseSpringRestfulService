package com.cifojava.libraryexercise.RestController;


import com.cifojava.libraryexercise.Model.Book;
import com.cifojava.libraryexercise.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookRestController {

    @Autowired
    BookRepository bookRepository;

    @GetMapping("/books")
    List<Book> showBooks(){
        return bookRepository.findAll();
    }


}
