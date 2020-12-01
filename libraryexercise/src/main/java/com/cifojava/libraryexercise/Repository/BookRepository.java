package com.cifojava.libraryexercise.Repository;

import com.cifojava.libraryexercise.Model.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {


    Iterable<Book> findAll();

    void deleteBookById(Long id);

    void deleteBookByTitle(String title);

    Optional<Book> findById(Long id);

}
