package com.example.DemoDBQuery.pojo;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "subjects")
public class Subjects {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long subjectCode;

    @Column(name = "subject_name")
    private String subjectName;

    @ManyToOne
    @JoinColumn(name = "student_code", nullable = false)
    private Student student;

    @ManyToMany
    @JoinTable(
        name = "subject_category",
        joinColumns = @JoinColumn(name = "subject_code"),
        inverseJoinColumns = @JoinColumn(name = "category_id")
    )

    private List<Category> categories;

    public Subjects() {
    }

    public Subjects(long subjectCode, String subjectName, Student student, List<Category> categories) {
        this.subjectCode = subjectCode;
        this.subjectName = subjectName;
        this.student = student;
        this.categories = categories;
    }

    public Subjects(String subjectName, Student student, List<Category> categories) {
        this.subjectName = subjectName;
        this.student = student;
        this.categories = categories;
    }

    public Subjects(String subjectName) {
        this.subjectName = subjectName;
    }

    public long getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectCode(long subjectCode) {
        this.subjectCode = subjectCode;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
}
