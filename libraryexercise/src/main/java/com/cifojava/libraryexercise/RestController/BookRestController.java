package com.cifojava.libraryexercise.RestController;


import com.cifojava.libraryexercise.Model.Book;
import com.cifojava.libraryexercise.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

//Setting as rest controller.
//CrossOrigins setted in order to guarantee access when we make calls from the front-end (in our case, the react app that
//uses this url in his local server created by node.js
@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api")
public class BookRestController {

    @Autowired
    BookService bookService;

    //BookMapper bookMapper;

    /*@GetMapping("/books")
    public ResponseEntity<List<BookDto>> showBooks(){

        return ResponseEntity.ok(bookMapper.toBookDTOs(bookService.findAllBooks()));
    }*/

    @GetMapping("/books")
    public Iterable<Book> showBooks(){
        return bookService.findAllBooks();
    }

    @PostMapping("/books")
    public Book newBook(@RequestBody Book book){
        return bookService.insertBook(book);
    }

    @GetMapping("/books{id}")
    public Optional<Book> showOneBookById(@PathVariable Long id){
        return bookService.showOneBookById(id);
    }

    @PutMapping("/books{id}")
    public Book replaceBook(@RequestBody Book newBook, @PathVariable Long id){
        return bookService.showOneBookById(id)
                .map(book -> {
                    book.setTitle(newBook.getTitle());
                    book.setISBN(newBook.getISBN());
                    book.setPages(newBook.getPages());
                    return bookService.insertBook(book);
                }).orElseGet(()->{
                    newBook.setId(id);
                    return bookService.insertBook(newBook);
                });
    }
    @DeleteMapping("/books{id}")
    public void deleteBookById(@PathVariable Long id){
        bookService.deleteBookById(id);
    }






}
