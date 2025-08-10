package com.example.bai89.service;

import com.example.bai89.model.Category;

import java.util.List;

public interface CategoryIServ {
    List<Category> getAll();

    Category getById(int id);

    boolean addCategory(Category category);

    boolean updateCategory(Category category);

    boolean deleteCategory(int id);
}
