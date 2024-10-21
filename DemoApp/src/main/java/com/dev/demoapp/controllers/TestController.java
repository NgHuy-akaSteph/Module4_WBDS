package com.dev.demoapp.controllers;



import com.dev.demoapp.entities.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller

public class TestController {

    @GetMapping("/create-user")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("form");
        modelAndView.addObject("user", new Customer());
        modelAndView.addObject("genders", new String[]{"Male", "Female", "Other"});
        modelAndView.addObject("hobbyArr", new String[]{"Reading", "Traveling", "Fishing", "Cooking"});
        modelAndView.addObject("types", new String[]{"Internal", "External"});
        modelAndView.addObject("countries", new String[]{"Vietnam", "United States", "United Kingdom", "Japan", "China"});
        return modelAndView;
    }

    @PostMapping("/create-user")
    public ModelAndView createUser(@ModelAttribute("user") Customer customer){
        ModelAndView modelAndView = new ModelAndView("display");
        modelAndView.addObject("user", customer);
        return modelAndView;
    }

}
