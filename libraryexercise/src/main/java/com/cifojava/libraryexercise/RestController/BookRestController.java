package com.cifojava.libraryexercise.RestController;


import com.cifojava.libraryexercise.Model.Book;
import com.cifojava.libraryexercise.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class BookRestController {

    @Autowired
    BookService bookService;

    @GetMapping("/books")
    public Iterable<Book> showBooks(){
        return bookService.findAllBooks();
    }



}
