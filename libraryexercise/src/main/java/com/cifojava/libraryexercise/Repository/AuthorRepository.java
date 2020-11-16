package com.cifojava.libraryexercise.Repository;

import com.cifojava.libraryexercise.Model.Author;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Long> {

}
