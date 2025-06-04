package com.example.DemoDBQuery.repository;

import com.example.DemoDBQuery.pojo.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
//    public void save(Category category);
//    public void delete(Long id);
//    public Category find(Long id);
//    public List<Category> findAll();
//    public void update(Category category);
}
