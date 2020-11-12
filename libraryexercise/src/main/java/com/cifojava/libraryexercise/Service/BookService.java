package com.cifojava.libraryexercise.Service;


import com.cifojava.libraryexercise.Model.Author;
import com.cifojava.libraryexercise.Model.Book;
import com.cifojava.libraryexercise.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> findAllBooks(){
        return bookRepository.findAll();
    }

    public void insertBook(Book book){
        bookRepository.save(book);
    }

    public void deleteBookByTitle(String title){
        bookRepository.deleteBookByTitle(title);
    }

    public void assignAuthorToBook(Book book, Author author){

    }
}
