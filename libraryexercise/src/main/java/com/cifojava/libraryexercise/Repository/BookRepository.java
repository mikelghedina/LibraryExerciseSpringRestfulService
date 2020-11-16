package com.cifojava.libraryexercise.Repository;

import com.cifojava.libraryexercise.Model.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;


public interface BookRepository extends CrudRepository<Book, Long> {


    void deleteBookByTitle(String title);

    Optional<Book> findById(Long id);
}
