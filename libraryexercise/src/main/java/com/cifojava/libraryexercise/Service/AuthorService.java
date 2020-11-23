package com.cifojava.libraryexercise.Service;

import com.cifojava.libraryexercise.Model.Author;
import com.cifojava.libraryexercise.Repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public List<Author> findAllAuthors(){
        return authorRepository.findAll();
    }

    public Optional<Author> findOneAuthorById(Long id){
        return authorRepository.findById(id);
    }

    public Author insertAuthor(Author author){
        authorRepository.save(author);
        return author;
    }

    public void deleteAuthorById(Long id){
        authorRepository.deleteById(id);
    }

}
