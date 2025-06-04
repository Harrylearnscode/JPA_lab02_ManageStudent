package com.example.DemoDBQuery.GUI;

import com.example.DemoDBQuery.pojo.Category;
import com.example.DemoDBQuery.pojo.Student;
import com.example.DemoDBQuery.pojo.Subjects;
import com.example.DemoDBQuery.service.CategoryService;
import com.example.DemoDBQuery.service.StudentService;
import com.example.DemoDBQuery.service.SubjectService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example.DemoDBQuery"
							, "com.example.DemoDBQuery.service"
							, "com.example.DemoDBQuery.pojo"
							, "com.example.DemoDBQuery.repository"})
@EnableJpaRepositories(basePackages = {"com.example.DemoDBQuery.repository"})
public class DemoDbQueryApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(DemoDbQueryApplication.class, args);
    }


	@Override
	public void run(String... args) throws Exception {
		//create students
		Student student1 = new Student("John Doe", "johndoe", "password123");
		Student student2 = new Student("Jane Smith", "janesmith", "password456");
		//create subjects
		Subjects subject1 = new Subjects("Mathematics");
		Subjects subject2 = new Subjects("Physics");
		Subjects subject3 = new Subjects("Chemistry");
		Subjects subject4 = new Subjects("History");
		//create categories
		Category category1 = new Category("Science", "science_url");
		Category category2 = new Category("Arts", "arts_url");
		Category category3 = new Category("Humanities", "humanities_url");
		Category category4 = new Category("Technology", "technology_url");
		//set relationships
		subject1.setStudent(student1);
		subject2.setStudent(student1);
		subject3.setStudent(student2);
		subject4.setStudent(student2);
		subject1.setCategories(List.of(category1, category2));
		subject2.setCategories(List.of(category1, category3));
		subject3.setCategories(List.of(category2, category4));
		subject4.setCategories(List.of(category3, category4));
		//save students
		StudentService studentService=null;
		studentService.save(student1);
		studentService.save(student2);
		//save subjects
		SubjectService subjectService = null;
		subjectService.save(subject1);
		subjectService.save(subject2);
		subjectService.save(subject3);
		subjectService.save(subject4);
		//save categories
		CategoryService categoryService = null;
		categoryService.saveCategory(category1);
		categoryService.saveCategory(category2);
		categoryService.saveCategory(category3);
		categoryService.saveCategory(category4);
		//fetch and display students
		List<Student> students = studentService.findAll();
		System.out.println("Students:");
		for (Student student : students) {
			System.out.println("Name: " + student.getName() + ", Username: " + student.getUsername());
			System.out.println("Subjects:");
			for (Subjects subject : student.getSubjects()) {
				System.out.println(" - " + subject.getSubjectName());
				System.out.println("   Categories:");
				for (Category category : subject.getCategories()) {
					System.out.println("   - " + category.getCatName());
				}
			}
		}
		//fetch and display subjects
		List<Subjects> subjects = subjectService.findAll();
		System.out.println("\nSubjects:");
		for (Subjects subject : subjects) {
			System.out.println("Subject Name: " + subject.getSubjectName());
			System.out.println("Student: " + subject.getStudent().getName());
			System.out.println("Categories:");
			for (Category category : subject.getCategories()) {
				System.out.println(" - " + category.getCatName());
			}
		}
		//fetch and display categories
		List<Category> categories = categoryService.getAllCategories();
		System.out.println("\nCategories:");
		for (Category category : categories) {
			System.out.println("Category Name: " + category.getCatName() + ", URL: " + category.getUrl());
			System.out.println("Subjects in this category:");
			for (Subjects subject : category.getSubjects()) {
				System.out.println(" - " + subject.getSubjectName());
			}
		}
		//delete a category
		Long categoryIdToDelete = 1L; // Example category ID to delete
		categoryService.deleteCategory(categoryIdToDelete);
		System.out.println("\nCategory with ID " + categoryIdToDelete + " deleted successfully.");
		//update a category
		Category categoryToUpdate = categoryService.findCategoryById(2L); // Example category ID to update
		if (categoryToUpdate != null) {
			categoryToUpdate.setCatName("Updated Category Name");
			categoryToUpdate.setUrl("updated_url");
			categoryService.updateCategory(categoryToUpdate);
			System.out.println("\nCategory with ID " + categoryToUpdate.getId() + " updated successfully.");
		} else {
			System.out.println("\nCategory not found for update.");
		}
		//find a category by ID
		Long categoryIdToFind = 3L; // Example category ID to find
		Category foundCategory = categoryService.findCategoryById(categoryIdToFind);
		if (foundCategory != null) {
			System.out.println("\nFound Category: " + foundCategory.getCatName() + ", URL: " + foundCategory.getUrl());
		} else {
			System.out.println("\nCategory with ID " + categoryIdToFind + " not found.");
		}
		//get all categories
		List<Category> allCategories = categoryService.getAllCategories();
		System.out.println("\nAll Categories:");
		for (Category category : allCategories) {
			System.out.println("Category Name: " + category.getCatName() + ", URL: " + category.getUrl());
		}



	}
}