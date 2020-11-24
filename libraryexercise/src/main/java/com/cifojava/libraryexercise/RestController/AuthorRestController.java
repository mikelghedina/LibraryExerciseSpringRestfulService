package com.cifojava.libraryexercise.RestController;


import com.cifojava.libraryexercise.Model.Author;
import com.cifojava.libraryexercise.Service.AuthorService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api")
public class AuthorRestController {

    @Autowired
    AuthorService authorService;

    @Autowired
    ObjectMapper objectMapper;

    @GetMapping("/authors")
    public List<Author> showAuthors(){
        return authorService.findAllAuthors();
    }

    @PostMapping("/authors")
    public Author newAuthor(@RequestBody Author author){
        return authorService.insertAuthor(author);
    }

    @GetMapping("/authors{id}")
    public Optional<Author> showOneAuthorById(@PathVariable Long id){
        return authorService.findOneAuthorById(id);
    }

    @PutMapping("/authors{id}")
    public Author replaceAuthor(@RequestBody Author newAuthor, @PathVariable Long id){
        return showOneAuthorById(id)
                .map(author -> {
                        author.setName(newAuthor.getName());
                        author.setLastName(newAuthor.getLastName());
                        return authorService.insertAuthor(author);
                }).orElseGet(()->{
                    newAuthor.setId(id);
                    return authorService.insertAuthor(newAuthor);
                });
    }

    @DeleteMapping("/authors{id}")
    public void deleteAuthorById(@PathVariable Long id){
        authorService.deleteAuthorById(id);
    }


}
