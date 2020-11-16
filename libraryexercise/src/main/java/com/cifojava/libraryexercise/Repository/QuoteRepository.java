package com.cifojava.libraryexercise.Repository;

import com.cifojava.libraryexercise.Model.Quote;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuoteRepository extends CrudRepository<Quote, String> {

}
