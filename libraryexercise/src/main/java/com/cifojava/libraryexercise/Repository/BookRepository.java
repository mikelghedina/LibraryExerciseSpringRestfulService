package com.cifojava.libraryexercise.Repository;

import com.cifojava.libraryexercise.Model.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

//When we use a custom method to make request to our database, the persistence context is not setted by default,
//otherwise default methods are already configured by spring so that's why we need to use Transactional annotation in
//order to use our custom methods and not get any possible error.
@Repository
public interface BookRepository extends CrudRepository<Book, Long> {


    @Transactional
    Iterable<Book> findAll();

    @Transactional
    void deleteBookById(Long id);

    @Transactional
    void deleteBookByTitle(String title);

    @Transactional
    Optional<Book> findById(Long id);

}
