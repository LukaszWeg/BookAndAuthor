package pl.lukasz.spring5webapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.lukasz.spring5webapp.repositories.BookRepository;

@Controller
public class BookController {
    private BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @RequestMapping(value = "/books")
    public String getBooks(Model model)
    {
        model.addAttribute("books", bookRepository.findAll());
        return "books";
    }
}

