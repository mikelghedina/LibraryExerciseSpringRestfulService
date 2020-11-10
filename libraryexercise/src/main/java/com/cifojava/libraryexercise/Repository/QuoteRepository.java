package com.cifojava.libraryexercise.Repository;

import com.cifojava.libraryexercise.Model.Quote;
import org.springframework.data.repository.CrudRepository;

public interface QuoteRepository extends CrudRepository<Quote, String> {

}
