package com.example.ss9.controller;

import com.example.ss9.entity.Book;
import com.example.ss9.service.BookService;
import com.example.ss9.service.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
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

    @GetMapping("/")
    public String displayBooks(@RequestParam(name="pageNo", required = false, defaultValue = "1") Integer pageNo, Model model) {
        Page<Book> list = bookService.findAll(pageNo);
        model.addAttribute("list", list);
        model.addAttribute("totalPages", list.getTotalPages());
        model.addAttribute("currentPage", pageNo);
        return "home";
    }

    @GetMapping("/book/{id}")
    public String displayBook(@PathVariable Long id, Model model) {
        model.addAttribute("book", bookService.findById(id));
        return "detail";
    }

    @GetMapping("/borrow/{id}")
    public String borrowBook(@PathVariable("id") Long id, Model model) {
        Integer borrowedId = bookService.borrowBook(id);
        if(borrowedId != null){
            model.addAttribute("borrowedId", borrowedId);
        }
        return "borrow-result";
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
        redirectAttributes.addFlashAttribute("borrowedId", id);
        return "redirect:/return-page";
    }
}
