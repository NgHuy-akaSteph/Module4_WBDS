package com.example.ss9.service;


import com.example.ss9.entity.Book;
import org.springframework.data.domain.Page;


public interface BookService {

    Page<Book> findAll(int pageNo);

    Book findById(Long id);

    Integer borrowBook(Long id);

    boolean returnBook(Integer borrowedId);
}
