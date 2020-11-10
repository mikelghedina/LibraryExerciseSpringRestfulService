package com.cifojava.libraryexercise.Controller;



import com.cifojava.libraryexercise.Model.Book;
import com.cifojava.libraryexercise.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/library")
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping("/books")
    public String showBooks(Model model){
        model.addAttribute("listOfBooks", bookService.findAllBooks());
        return "webapp/Books/indexBooks";
    }

    @RequestMapping("/newBook")
    public String newBook(){
        return "webapp/Books/newBook";
    }

    @RequestMapping("/insertBook")
    public String insertBook(Model model, Book book){
        bookService.insertBook(book);
        model.addAttribute("listOfBooks", bookService.findAllBooks());
        return "webapp/Books/indexBooks";
    }

    @RequestMapping("/deleteBook")
    public String deleteBook(@RequestParam("title") String title, Model model){

        Book book = new Book(title);

        bookService.deleteBook(book);

        model.addAttribute("listOfBooks", bookService.findAllBooks());
        System.out.println("title: "+ title);
        return "webapp/Books/indexBooks";
    }




}
