package com.example.ss9.dto;

public class BookDTO {
    private Long id;

    private String title;

    private String category;

    private String author;

    private String publisher;

    private Integer year;

    private String language;

    private int quantity;

    public BookDTO() {
    }

    public BookDTO(String title, String category, String author, String publisher, Integer year, String language, int quantity) {
        this.title = title;
        this.category = category;
        this.author = author;
        this.publisher = publisher;
        this.year = year;
        this.language = language;
        this.quantity = quantity;
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
