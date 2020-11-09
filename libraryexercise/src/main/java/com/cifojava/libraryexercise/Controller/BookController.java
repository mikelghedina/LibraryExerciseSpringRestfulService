package com.cifojava.libraryexercise.Controller;



import com.cifojava.libraryexercise.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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


}
