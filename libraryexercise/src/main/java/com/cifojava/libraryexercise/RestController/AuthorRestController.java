package com.cifojava.libraryexercise.RestController;


import com.cifojava.libraryexercise.Model.Author;
import com.cifojava.libraryexercise.Service.AuthorService;
import com.cifojava.libraryexercise.Service.Mapper.BookMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
//Setting as rest controller.
//CrossOrigins setted in order to guarantee access when we make calls from the front-end (in our case, the react app that
//uses this url in his local server created by node.js
@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api")
public class AuthorRestController {

    //injecting author service
    @Autowired
    AuthorService authorService;

    //Get request methods
    @GetMapping("/authors")
    public List<Author> showAuthors(){
        return authorService.findAllAuthors();
    }

    @GetMapping("/authors{id}")
    public Optional<Author> showOneAuthorById(@PathVariable Long id){
        return authorService.findOneAuthorById(id);
    }
    //Post request Methods
    @PostMapping("/authors")
    public Author newAuthor(@RequestBody Author author){
        return authorService.insertAuthor(author);
    }
    //Put request Methods
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

    //Delete request Methods.
    @DeleteMapping("/authors{id}")
    public void deleteAuthorById(@PathVariable Long id){
        authorService.deleteAuthorById(id);
    }


}
