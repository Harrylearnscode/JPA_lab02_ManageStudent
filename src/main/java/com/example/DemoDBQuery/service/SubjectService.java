package com.example.DemoDBQuery.service;

import com.example.DemoDBQuery.pojo.Subjects;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public interface SubjectService{
    void save(Subjects subject);
    List<Subjects> findAll();
    void delete(long subjectCode);
    void update(Subjects subject);
    Optional<Subjects> find(long subjectCode);

}
