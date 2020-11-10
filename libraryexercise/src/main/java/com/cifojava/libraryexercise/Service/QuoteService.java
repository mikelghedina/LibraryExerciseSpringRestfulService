package com.cifojava.libraryexercise.Service;


import com.cifojava.libraryexercise.Model.Quote;
import com.cifojava.libraryexercise.Repository.QuoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuoteService {


    @Autowired
    QuoteRepository quoteRepository;

    public Iterable<Quote> showQuotes(){
        return quoteRepository.findAll();
    }

    public void insertQuote(Quote quote){
        quoteRepository.save(quote);
    }

    public void deleteQuote(Quote quote){
        quoteRepository.delete(quote);
    }

}
