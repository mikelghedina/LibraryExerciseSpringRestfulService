package com.cifojava.libraryexercise.Repository;

import com.cifojava.libraryexercise.Model.Quote;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuoteRepository extends CrudRepository<Quote, Long> {


    List<Quote> findAll();
    void deleteById(Long id);

}
