package com.cifojava.libraryexercise.Repository;

import com.cifojava.libraryexercise.Model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, String> {


}
