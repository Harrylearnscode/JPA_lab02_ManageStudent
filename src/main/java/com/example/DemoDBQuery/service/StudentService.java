package com.example.DemoDBQuery.service;

import com.example.DemoDBQuery.pojo.Student;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface StudentService {
    void save(Student student);
    Optional<Student> find(long studentId);
    void delete(long studentId);
    void update(Student student);
    List<Student> findAll();
}
