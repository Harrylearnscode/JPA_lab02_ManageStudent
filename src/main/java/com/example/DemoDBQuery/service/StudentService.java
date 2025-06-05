package com.example.DemoDBQuery.service;

import com.example.DemoDBQuery.pojo.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {
    void save(Student student);
    Student find(long studentId);
    void delete(long studentId);
    void update(Student student);
    List<Student> findAll();
}
