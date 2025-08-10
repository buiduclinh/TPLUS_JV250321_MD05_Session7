package com.example.bai4567.controller;

import com.example.bai4567.model.UserForm;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value = {"/","/RegistrationController"})
@Controller
public class RegistrationController {

    @GetMapping("/register")
    public String showForm(Model model) {
        model.addAttribute("userForm", new UserForm());
        return "register";
    }

    @PostMapping("/register")
    public String processForm(@Valid @ModelAttribute("userForm") UserForm userForm,
                              BindingResult bindingResult,
                              Model model) {
        if (bindingResult.hasErrors()) {
            return "register"; // Trả lại form nếu có lỗi
        }
        model.addAttribute("user", userForm);
        return "result";
    }
}
