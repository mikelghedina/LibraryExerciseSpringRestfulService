package com.cifojava.libraryexercise.RestController;


import com.cifojava.libraryexercise.Model.Author;
import com.cifojava.libraryexercise.Service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AuthorRestController {

    @Autowired
    AuthorService authorService;

    @GetMapping("/authors")
    public Iterable<Author> showAuthors(){
        return authorService.findAllAuthors();
    }
}
