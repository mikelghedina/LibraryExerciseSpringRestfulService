package com.cifojava.libraryexercise.Service;


import com.cifojava.libraryexercise.Model.Book;
import com.cifojava.libraryexercise.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public Iterable<Book> findAllBooks(){
        return bookRepository.findAll();
    }

    public void insertBook(Book book){
        bookRepository.save(book);
    }

    public void deleteBookByTitle(String title){
        bookRepository.deleteBookByTitle(title);
    }
    public void deleteBook(Book book){
        bookRepository.delete(book);
    }
}
