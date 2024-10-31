package com.example.ss9.dao;

import com.example.ss9.entity.BorrowedBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BorrowedBookDAO extends JpaRepository<BorrowedBook, Integer> {
}
