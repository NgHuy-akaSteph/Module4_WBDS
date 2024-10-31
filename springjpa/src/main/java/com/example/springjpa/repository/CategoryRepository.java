package com.example.springjpa.repository;

import com.example.springjpa.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Query(value="select c from Category c join fetch c.blogs where c.id = :id")
    Category findCategoryAndBlogsByCategoryId(@Param("id") Long id);

    
}
