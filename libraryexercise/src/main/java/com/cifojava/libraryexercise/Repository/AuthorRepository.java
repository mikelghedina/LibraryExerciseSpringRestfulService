package com.cifojava.libraryexercise.Repository;

import com.cifojava.libraryexercise.Model.Author;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AuthorRepository extends JpaRepository<Author, Long> {

}
