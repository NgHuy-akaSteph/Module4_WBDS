package com.example.ss9.entity;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.validation.constraints.NotNull;

import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="title")
    @NotNull
    private String title;

    @Column(name="category",columnDefinition = "VARCHAR(100)")
    @NotNull
    private String category;

    @Column(name="author", columnDefinition = "VARCHAR(100) Default 'Unknown'")
    private String author;

    @Column(name="publisher")
    private String publisher;

    @Column(name="year")
    private Integer year;

    @Column(name="language", columnDefinition = "VARCHAR(50) Default 'English'")
    private String language;

    @Column(name="quantity")
    @NotNull
    private int quantity;

    @OneToMany(mappedBy = "book", fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    private List<BorrowedBook> borrowedBooks;

    public Book() {
    }

    public Book(String title, String category, String author, String publisher, Integer year, String language, int quantity) {
        this.title = title;
        this.category = category;
        this.author = author;
        this.publisher = publisher;
        this.year = year;
        this.language = language;
        this.quantity = quantity;
    }

    public void addBorrowedBook(BorrowedBook borrowedBook) {
        borrowedBooks.add(borrowedBook);
        borrowedBook.setBook(this);
    }

    public void removeBorrowedBook(BorrowedBook borrowedBook) {
        borrowedBooks.remove(borrowedBook);
        borrowedBook.setBook(null);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
