package com.example.ss9.service;

import com.example.ss9.dao.BookDAO;
import com.example.ss9.dao.BorrowedBookDAO;
import com.example.ss9.entity.Book;
import com.example.ss9.entity.BorrowedBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class BookServiceImpl implements BookService {

    private BookDAO bookDAO;
    private BorrowedBookDAO BorrowedBookDAO;

    @Autowired
    public BookServiceImpl(BookDAO bookDAO, BorrowedBookDAO borrowedBookDAO) {
        this.bookDAO = bookDAO;
        BorrowedBookDAO = borrowedBookDAO;
    }

    @Override
    public Page<Book> findAll(int page, int size) {
        return bookDAO.findAll(PageRequest.of(page, size));
    }

    @Override
    public Book findById(Long id) {
        return bookDAO.findById(id).orElse(null);
    }

    @Override
    public boolean borrowBook(Long id) {
        Book book = bookDAO.findById(id).orElse(null);
        if(book != null){
            int quantity = book.getQuantity();
            if(quantity > 0){
                book.setQuantity(quantity - 1);
                book.addBorrowedBook(new BorrowedBook());
                bookDAO.save(book);
            }
        }
        return false;
    }

    @Override
    @Transactional
    public boolean returnBook(Integer borrowedId) {
        BorrowedBook borrowedBook = BorrowedBookDAO.findById(borrowedId).orElse(null);
        if(borrowedBook != null){
            Book book = borrowedBook.getBook();
            book.setQuantity(book.getQuantity() + 1);
            book.removeBorrowedBook(borrowedBook);
            bookDAO.save(book);
            BorrowedBookDAO.deleteById(borrowedId);
            return true;
        }
        return false;
    }
}
