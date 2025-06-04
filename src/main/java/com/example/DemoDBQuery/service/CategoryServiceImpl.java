package com.example.DemoDBQuery.service;

    import com.example.DemoDBQuery.pojo.Category;
    import com.example.DemoDBQuery.repository.CategoryRepository;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Service;

    import java.util.List;

    @Service
    public class CategoryServiceImpl implements CategoryService {
        @Autowired
        private CategoryRepository categoryRepository;

        @Override
        public void saveCategory(Category category) {
            categoryRepository.save(category);
        }

        @Override
        public List<Category> getAllCategories() {
            return categoryRepository.findAll();
        }

        @Override
        public void deleteCategory(Long categoryId) {
            if (categoryRepository.existsById(categoryId)) {
                categoryRepository.deleteById(categoryId);
                System.out.println("Category with ID " + categoryId + " has been deleted.");
            } else {
                System.out.println("Category with ID " + categoryId + " does not exist.");
            }
        }

        @Override
        public void updateCategory(Category category) {
            if (categoryRepository.existsById(category.getId())) {
                categoryRepository.save(category);
                System.out.println("Category with ID " + category.getId() + " has been updated.");
            } else {
                System.out.println("Category with ID " + category.getId() + " does not exist.");
            }
        }

        @Override
        public Category findCategoryById(long categoryId) {
            return categoryRepository.findById(categoryId).orElse(null);
        }
    }