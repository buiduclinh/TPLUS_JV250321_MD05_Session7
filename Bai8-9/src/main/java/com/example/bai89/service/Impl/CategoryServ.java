package com.example.bai89.service.Impl;

import com.example.bai89.model.Category;
import com.example.bai89.repo.CategoryDAO;
import com.example.bai89.service.CategoryIServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServ implements CategoryIServ {
    @Autowired
    CategoryDAO categoryDAO;

    @Override
    public List<Category> getAll() {
        return categoryDAO.getAll();
    }

    @Override
    public Category getById(int id) {
        return categoryDAO.getById(id);
    }

    @Override
    public boolean addCategory(Category category) {
        return categoryDAO.addCategory(category);
    }

    @Override
    public boolean updateCategory(Category category) {
        return categoryDAO.updateCategory(category);
    }

    @Override
    public boolean deleteCategory(int id) {
        return categoryDAO.deleteCategory(id);
    }
}
