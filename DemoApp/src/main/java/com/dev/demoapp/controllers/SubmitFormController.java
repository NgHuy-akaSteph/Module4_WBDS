package com.dev.demoapp.controllers;

import com.dev.demoapp.entities.MedicalForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/medical")
public class SubmitFormController {

    @GetMapping("/form")
    public String showForm(Model model) {
        model.addAttribute("medicalForm", new MedicalForm());
        return "medical-form";
    }

    @PostMapping("/submit")
    public String submitForm(@ModelAttribute("medicalForm") MedicalForm medicalForm) {
        System.out.println(medicalForm.getFullName());
        System.out.println(medicalForm.getYearOfBirth());
        System.out.println(medicalForm.getIDNumber());
        System.out.println(medicalForm.getVehicle());
        System.out.println(medicalForm.getVehicleNumber());
        System.out.println(medicalForm.getSymptoms());
        return "success";
    }
}
