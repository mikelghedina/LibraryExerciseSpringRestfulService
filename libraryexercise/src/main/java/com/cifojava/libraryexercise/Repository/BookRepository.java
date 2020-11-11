package com.cifojava.libraryexercise.Repository;

import com.cifojava.libraryexercise.Model.Book;
import org.springframework.data.repository.CrudRepository;


public interface BookRepository extends CrudRepository<Book, String> {

    void deleteBookByTitle(String title);

}
