package com.example.springjpa.repository;

import com.example.springjpa.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BlogRepository extends JpaRepository<Blog, Long> {

    @Query(value = "select b from Blog b where b.title like :title")
    List<Blog> findBlogByTitle(@Param("title")String title);


}
