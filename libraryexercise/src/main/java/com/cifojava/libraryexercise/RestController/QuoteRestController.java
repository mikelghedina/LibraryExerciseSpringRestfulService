package com.cifojava.libraryexercise.RestController;

import com.cifojava.libraryexercise.Model.Quote;
import com.cifojava.libraryexercise.Service.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class QuoteRestController {

    @Autowired
    QuoteService quoteService;

    @GetMapping("/quotes")
    public List<Quote> showQuotes(){
        return quoteService.showQuotes();
    }

    @PostMapping("/quotes")
    public Quote newQuote(@RequestBody Quote quote){
        return quoteService.insertQuote(quote);
    }

    @GetMapping("/quotes{id}")
    public Optional<Quote> showOneQuoteById(@PathVariable Long id){
        return quoteService.findOneQuoteById(id);
    }

    @PutMapping("/quotes{id}")
    public Quote replaceQuote(@RequestBody Quote newQuote, @PathVariable Long id){
        return quoteService.findOneQuoteById(id)
                .map(quote -> {
                    quote.setContent(newQuote.getContent());
                    return quoteService.insertQuote(quote);
                }).orElseGet(()->{
                    newQuote.setId(id);
                    return quoteService.insertQuote(newQuote);
                });
    }

    @DeleteMapping("/quotes{id}")
    public void deleteQuoteById(@PathVariable Long id){
        quoteService.deleteQuoteById(id);
    }

}
