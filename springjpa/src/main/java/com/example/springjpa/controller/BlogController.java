package com.example.springjpa.controller;
import com.example.springjpa.model.Blog;
import com.example.springjpa.sevice.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/")
public class BlogController {

    private final BlogService blogService;

    @Autowired
    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }


    @GetMapping("home")
    public String home(@RequestParam(name = "page", defaultValue = "0") int page, Model model){
        model.addAttribute("blogs", blogService.findAllPagingAndSorting(page, 5, "createdAt", "asc"));
        return "home";
    }

    @GetMapping("blog/{id}")
    public String viewDetail(@PathVariable("id") Long id, Model model){
        Blog blog = blogService.getBlogById(id);
        if (blog != null) {
            model.addAttribute("blog", blog);
            return "blogDetail";
        } else {
            System.out.println("Blog not found");
            return "redirect:/home";
        }
    }

    @GetMapping("blog/{id}/delete")
    public String deleteBlog(@PathVariable("id") Long id){
        blogService.deleteBlog(id);
        return "redirect:/home";
    }

    @GetMapping("blog/{id}/edit")
    public String showEditForm(@PathVariable("id") Long id, Model model){
        model.addAttribute("blog", blogService.getBlogById(id));
        return "edit";
    }

    @PostMapping("blog/{id}/edit")
    public String editBlog(@PathVariable("id") Long id, @ModelAttribute("blog") Blog blog){
        blogService.saveBlog(blog);
        return "redirect:/home";
    }

    @GetMapping("create")
    public String showCreateForm(Model model){
        model.addAttribute("blog", new Blog());
        return "newBlog";
    }

    @PostMapping("create")
    public String createBlog(@ModelAttribute("blog") Blog blog){
        blogService.saveBlog(blog);
        return "redirect:/home";
    }

    @GetMapping("search")
    public String searchBlog(@RequestParam("keyword") String keyword, Model model){
        String title = "%" + keyword + "%";
        List<Blog> results = blogService.findBlogByTitle(title);
        model.addAttribute("blogs", results);
        return "home";
    }
}
