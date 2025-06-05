package com.example.DemoDBQuery.service;

import com.example.DemoDBQuery.pojo.Student;
import com.example.DemoDBQuery.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public Student find(long studentId) {
        if(studentRepository.findById(studentId)!= null) {
            return studentRepository.findById(studentId).get();
        }
        return null;
    }

    @Override
    public void delete(long studentId) {
        if(studentRepository.findById(studentId) != null) {
            studentRepository.deleteById(studentId);
            System.out.println("Student with ID " + studentId + " has been deleted.");
        } else {
            System.out.println("Student with ID " + studentId + " does not exist.");
        }
    }

    @Override
    public void update(Student student) {
        if(studentRepository.findById(student.getCode()).isPresent()) {
            studentRepository.save(student);
            System.out.println("Student with ID " + student.getCode() + " has been updated.");
        } else {
            System.out.println("Student with ID " + student.getCode() + " does not exist.");
        }

    }

    @Override
    public List<Student> findAll() {
        if (studentRepository.findAll() != null) {
            return studentRepository.findAll();
        }
        return null;
    }
}
