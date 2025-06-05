package com.example.DemoDBQuery.service;

import com.example.DemoDBQuery.pojo.Subjects;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public interface SubjectService{
    void save(Subjects subject);
    List<Subjects> findAll();
    void delete(long subjectCode);
    void update(Subjects subject);
    Subjects find(long subjectCode);

}
