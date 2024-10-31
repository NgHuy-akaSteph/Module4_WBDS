package com.example.springjpa.sevice;

import com.example.springjpa.model.Blog;
import org.springframework.data.domain.Page;

import java.util.List;

public interface BlogService {

    List<Blog> getAllBlogs();

    Blog getBlogById(Long id);

    List<Blog> findBlogByTitle(String title);

    Page<Blog> findAllPagingAndSorting(int page, int size, String sortField, String sortDir);

    void saveBlog(Blog blog);

    void deleteBlog(Long id);
}
