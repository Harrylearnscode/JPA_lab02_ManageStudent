package com.example.DemoDBQuery.service;

import com.example.DemoDBQuery.pojo.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {
    void saveCategory(Category category);
    Category findCategoryById(long categoryId);
    void deleteCategory(Long categoryId);
    void updateCategory(Category category);
    List<Category> getAllCategories();

}
