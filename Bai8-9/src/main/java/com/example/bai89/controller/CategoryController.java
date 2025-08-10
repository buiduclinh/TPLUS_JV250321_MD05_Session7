package com.example.bai89.controller;

import com.example.bai89.model.Category;
import com.example.bai89.repo.CategoryDAO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = {"/", "/CategoryController"})
public class CategoryController {
    @Autowired
    CategoryDAO categoryDAO;

    @GetMapping("/getAll")
    String getAll(Model model) {
        List<Category> categoryList = categoryDAO.getAll();
        model.addAttribute("categoryList", categoryList);
        return "categoryView";
    }

    @GetMapping("/addCategory")
    String addCategory(Model model) {
        model.addAttribute("category", new Category());
        return "categoryAdd";
    }

    @PostMapping("/addCategory")
    String addCategory(@Valid @ModelAttribute("category") Category category, BindingResult result) {
        if(result.hasErrors()) {
            return "categoryAdd";
        }
        categoryDAO.addCategory(category);
        return "redirect:/getAll";
    }

    @GetMapping("/getCategory")
    String getCategory(@RequestParam("id") int id, Model model) {
        Category category = categoryDAO.getById(id);
        model.addAttribute("category", category);
        return "categoryUpdate";
    }

    @PostMapping("/update")
    String update(@Valid @ModelAttribute("category") Category category, BindingResult result) {
        if (result.hasErrors()) {
            return "categoryUpdate";
        }
        categoryDAO.updateCategory(category);
        return "redirect:/getAll";
    }

    @GetMapping("/deleteCategory")
    String deleteCategory(@RequestParam("id") int id) {
        categoryDAO.deleteCategory(id);
        return "redirect:/getAll";
    }
}
