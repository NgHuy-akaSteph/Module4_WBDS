package com.example.springjpa.sevice;

import com.example.springjpa.model.Category;

import java.util.List;

public interface CategoryService {

    List<Category> getAllCategories();

    Category getCategoryById(Long id);

    Category getCategoryAndBlogsById(Long id);

    void saveCategory(Category category);

    void deleteCategoryById(Long id);
}
