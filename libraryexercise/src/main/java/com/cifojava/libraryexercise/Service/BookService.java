package com.cifojava.libraryexercise.Service;


import com.cifojava.libraryexercise.Model.Author;
import com.cifojava.libraryexercise.Model.Book;
import com.cifojava.libraryexercise.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Service
@Transactional
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public Iterable<Book> findAllBooks(){
        return bookRepository.findAll();
    }

    public Book insertBook(Book book){
        bookRepository.save(book);
        return book;
    }
    public Optional<Book> showOneBookById(Long id){
        return bookRepository.findById(id);
    }

    public void deleteBookById(Long id){
        bookRepository.deleteById(id);
    }

    public void deleteBookByTitle(String title){
        bookRepository.deleteBookByTitle(title);
    }

    public void assignAuthorToBook(Book book, Author author){

    }
}
