package com.dev.springvalid.controller;

import com.dev.springvalid.model.Customer;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustomerController {

    @GetMapping("/")
    public String showForm(Model model){
        model.addAttribute("customer", new Customer());
        return "form";
    }

    @PostMapping("/registry")
    public String register(@Valid @ModelAttribute("customer") Customer customer, Model model, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "form";
        }
        model.addAttribute("customer", customer);
        return "home";
    }
}
