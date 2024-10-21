package com.example.demothymeleaf.controller;

import com.example.demothymeleaf.entities.User;
import com.example.demothymeleaf.service.UserService;
import com.example.demothymeleaf.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("list", userService.findAll());
        return "home";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id){
        userService.deleteById(id);
        return "redirect:/users/home";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("newUser", new User());
        return "create-form";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("newUser") User newUser) {
        newUser.setId(userService.generateId());
        userService.save(newUser);
        return "redirect:/users/home";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("user", userService.findById(id));
        return "edit-form";
    }

    @PostMapping(value = "/edit")
    public String edit( @ModelAttribute("user") User user) {
        user.setId(user.getId());
        userService.save(user);
        return "redirect:/users/home";
    }
}
