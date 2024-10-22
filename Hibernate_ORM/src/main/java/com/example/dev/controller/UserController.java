package com.example.dev.controller;


import com.example.dev.entity.User;
import com.example.dev.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/users")
    public String getUsers(Model model){
        List<User> users = userService.findAll();
        model.addAttribute("list", users);
        return "home";
    }

    @GetMapping("/users/delete/{id}")
    public String deleteUser(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes){
        if(userService.deleteById(id)){
            redirectAttributes.addFlashAttribute("message", "User deleted successfully");
        } else {
            redirectAttributes.addFlashAttribute("message", "Error deleting user");
        }
        return "redirect:/users";
    }

    @GetMapping("/users/create")
    public String showCreateForm(Model model){
        model.addAttribute("user", new User());
        return "create";
    }

    @PostMapping("/users/create")
    public String createUser(@ModelAttribute("user") User user, RedirectAttributes redirectAttributes){
        if(userService.save(user)){
            redirectAttributes.addFlashAttribute("message", "User saved successfully");
        } else {
            redirectAttributes.addFlashAttribute("message", "Error saving user");
        }
        return "redirect:/users";
    }


}
