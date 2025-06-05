package com.example.DemoDBQuery.service;

import com.example.DemoDBQuery.pojo.Student;
import com.example.DemoDBQuery.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Collections;

@Service
public class StudentServiceImpl implements StudentService{
    // Implement the methods defined in StudentService interface here
    @Autowired
    private StudentRepository studentRepository; // Assuming you have a StudentRepository for database operations


    @Override
    public void save(Student student) {
        // Save the student to the database
        studentRepository.save(student);

    }

    @Override
    public Optional<Student> find(long studentId) {
        return studentRepository.findById(studentId);
    }

    @Override
    public void delete(long studentId) {
        if(studentRepository.findById(studentId).isPresent()) { // isPresent() is more idiomatic for Optional
            studentRepository.deleteById(studentId);
        }
    }

    @Override
    public void update(Student student) {
        if(studentRepository.findById(student.getCode()).isPresent()) {
            studentRepository.save(student);
        }

    }

    @Override
    public List<Student> findAll() {
        List<Student> students = studentRepository.findAll();
        return students == null ? Collections.emptyList() : students;
    }
}
