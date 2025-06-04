package com.example.DemoDBQuery.repository;


import com.example.DemoDBQuery.pojo.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
//    public Object save(Student student);
//    public void delete(int studentId);
//    public Student find(int studentId);
//    public List<Student> findAll();
//    public void update(Student student);
}
