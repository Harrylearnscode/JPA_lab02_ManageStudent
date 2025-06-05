package com.example.DemoDBQuery.service;

import com.example.DemoDBQuery.pojo.Category;
import com.example.DemoDBQuery.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        if(categoryRepository.findAll()!= null) {
            return categoryRepository.findAll();
        }
        return null;

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
    public Category findCategoryById(long categoryId) {
        return categoryRepository.findById(categoryId).orElse(null);
    }
}
