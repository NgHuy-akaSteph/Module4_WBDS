package com.example.ss9.controller;

import com.example.ss9.service.BookService;
import com.example.ss9.service.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class BookController {

    private BookService bookService;

    @Autowired
    public BookController(BookServiceImpl bookService) {
        this.bookService = bookService;
    }

    private static int pageSize = 4;

    @GetMapping("/")
    public String displayBooks(@RequestParam(name="page", required = false, defaultValue = "0") Integer page, Model model) {
        model.addAttribute("list", bookService.findAll(page, pageSize));
        return "home";
    }

    @GetMapping("/book/{id}")
    public String displayBook(@PathVariable Long id, Model model) {
        model.addAttribute("book", bookService.findById(id));
        return "detail";
    }

    @GetMapping("/borrow/{id}")
    public String borrowBook(@PathVariable("id") Long id, Model model) {
        bookService.borrowBook(id);
        return "redirect:/";
    }

    @GetMapping("/return-page")
    public String showReturnPage() {
        return "return-book";
    }

    @GetMapping("/return")
    public String returnBook(@RequestParam(name="borrowedId") Integer id, RedirectAttributes redirectAttributes) {
        if(bookService.returnBook(id)){
            return "redirect:/";
        }
        redirectAttributes.addFlashAttribute("message", "Not found borrowed book's id");
        return "redirect:/return-page";
    }
}
