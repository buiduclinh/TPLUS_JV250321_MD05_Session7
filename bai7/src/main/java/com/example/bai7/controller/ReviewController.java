package com.example.bai7.controller;

import com.example.bai7.model.ReviewForm;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value = {"/","/ReviewController"})
@Controller
public class ReviewController {

    @GetMapping("/review")
    public String showForm(Model model) {
        model.addAttribute("reviewForm", new ReviewForm());
        return "review-form"; // tên JSP
    }

    @PostMapping("/review")
    public String submitForm(
            @Valid @ModelAttribute("reviewForm") ReviewForm reviewForm,
            BindingResult bindingResult,
            Model model) {

        if (bindingResult.hasErrors()) {
            return "review-form"; // quay lại form nếu có lỗi
        }

        model.addAttribute("successMsg", "Cảm ơn bạn đã đánh giá!");
        return "review-success";
    }
}