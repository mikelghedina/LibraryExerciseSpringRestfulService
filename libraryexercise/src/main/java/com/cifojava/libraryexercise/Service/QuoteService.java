package com.cifojava.libraryexercise.Service;


import com.cifojava.libraryexercise.Model.Quote;
import com.cifojava.libraryexercise.Repository.QuoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class QuoteService {


    @Autowired
    private QuoteRepository quoteRepository;

    public List<Quote> showQuotes(){
        return quoteRepository.findAll();
    }
    public Optional<Quote> findOneQuoteById(Long id){
        return quoteRepository.findById(id);
    }

    public Quote insertQuote(Quote quote){
        quoteRepository.save(quote);
        return quote;
    }

    public void deleteQuoteById(Long id){
        quoteRepository.deleteById(id);
    }

}
