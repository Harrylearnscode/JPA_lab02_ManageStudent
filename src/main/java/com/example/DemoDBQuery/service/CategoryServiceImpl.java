package com.example.DemoDBQuery.service;

import com.example.DemoDBQuery.pojo.Category;
import com.example.DemoDBQuery.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Collections;

@Service
public class CategoryServiceImpl implements CategoryService{
    // Implement the methods defined in CategoryService interface here
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public void saveCategory(Category category) {
        // Implementation for creating a category
        categoryRepository.save(category);
    }

    @Override
    public List<Category> getAllCategories() {
        List<Category> categories = categoryRepository.findAll();
        return categories == null ? Collections.emptyList() : categories;
    }

    @Override
    public void deleteCategory(Long categoryId) {
        categoryRepository.deleteById(categoryId);
    }

    @Override
    public void updateCategory(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public Optional<Category> findCategoryById(long categoryId) {
        return categoryRepository.findById(categoryId);
    }
}
