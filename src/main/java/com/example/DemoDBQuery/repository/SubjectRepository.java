package com.example.DemoDBQuery.repository;

import com.example.DemoDBQuery.pojo.Subjects;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubjectRepository extends JpaRepository<Subjects, Long> {
}
