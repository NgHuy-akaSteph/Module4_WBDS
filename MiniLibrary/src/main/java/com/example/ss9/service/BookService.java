package com.example.ss9.service;


import com.example.ss9.entity.Book;
import org.springframework.data.domain.Page;


public interface BookService {

    Page<Book> findAll(int page, int size);

    Book findById(Long id);

    boolean borrowBook(Long id);

    boolean returnBook(Integer borrowedId);
}
