package com.example.DemoDBQuery.GUI;

import com.example.DemoDBQuery.pojo.Category;
import com.example.DemoDBQuery.pojo.Student;
import com.example.DemoDBQuery.pojo.Subjects;
import com.example.DemoDBQuery.service.CategoryService;
import com.example.DemoDBQuery.service.StudentService;
import com.example.DemoDBQuery.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
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

	@Autowired
	private StudentService studentService;

	@Override
	public void run(String... args) throws Exception {
		Student student = new Student("John", "haha", "1234" );
		studentService.save(student);
	}
}