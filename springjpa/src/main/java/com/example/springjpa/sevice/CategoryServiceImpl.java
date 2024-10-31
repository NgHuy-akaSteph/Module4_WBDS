package com.example.springjpa.sevice;

import com.example.springjpa.model.Blog;
import com.example.springjpa.model.Category;
import com.example.springjpa.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }

    @Override
    public Category getCategoryAndBlogsById(Long id) {
        return categoryRepository.findCategoryAndBlogsByCategoryId(id);
    }

    @Override
    @Transactional
    public void saveCategory(Category category) {
        categoryRepository.save(category);
    }

    @Override
    @Transactional
    public void deleteCategoryById(Long id) {
        Category tmpCategory = categoryRepository.findById(id).orElse(null);
        // check if category exists
        if (Objects.isNull(tmpCategory)) {
            return;
        }
        // remove association between blog and category
        for(Blog blog : tmpCategory.getBlogs()){
            blog.setCategory(null);
        }
        // remove category
        categoryRepository.deleteById(id);
    }

}
