package com.cifojava.libraryexercise.Controller;




import com.cifojava.libraryexercise.Model.Book;
import com.cifojava.libraryexercise.Service.AuthorService;
import com.cifojava.libraryexercise.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/library")
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private AuthorService authorService;

    @RequestMapping("/books")
    public String showBooks(Model model){
        model.addAttribute("listOfBooks", bookService.findAllBooks());
        return "webapp/Books/indexBooks";
    }

    @RequestMapping("/newBook")
    public String newBook(Model model){
        model.addAttribute("listOfAuthors", authorService.findAllAuthors());
        return "webapp/Books/newBook";
    }

    @RequestMapping("/insertBook")
    public String insertBook(Model model, Book book){

        bookService.insertBook(book);

        model.addAttribute("listOfBooks", bookService.findAllBooks());

        return showBooks(model);
    }

    @RequestMapping("/deleteBook")
    public String deleteBookById(@RequestParam("title") String title, Model model){

        bookService.deleteBookByTitle(title);

        model.addAttribute("listOfBooks", bookService.findAllBooks());
        System.out.println("title: "+ title);
        return showBooks(model);
    }
}
