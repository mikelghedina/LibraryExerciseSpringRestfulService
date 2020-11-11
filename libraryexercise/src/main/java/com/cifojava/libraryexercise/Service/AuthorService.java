package com.cifojava.libraryexercise.Service;

import com.cifojava.libraryexercise.Model.Author;
import com.cifojava.libraryexercise.Repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public Iterable<Author> findAllAuthors(){
        return authorRepository.findAll();
    }

    public void insertAuthor(Author author){
        authorRepository.save(author);
    }

    public void deleteAuthor(Author author){
        authorRepository.delete(author);
    }

}
