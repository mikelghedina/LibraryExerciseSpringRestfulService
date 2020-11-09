package com.cifojava.libraryexercise.Controller;

import com.cifojava.libraryexercise.Service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/library")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @RequestMapping("/authors")
    public String showAuthors(Model model){
        model.addAttribute("listOfauthors", authorService.findAllAuthors());
        return "/webapp/Authors/indexAuthors";
    }

    @RequestMapping("/newAuthor")
    public String newAuthor(){
        return "webapp/Authors/newAuthor";
    }




}
