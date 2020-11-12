package com.cifojava.libraryexercise.Repository;

import com.cifojava.libraryexercise.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BookRepository extends JpaRepository<Book, Long> {


    void deleteBookByTitle(String title);
}
