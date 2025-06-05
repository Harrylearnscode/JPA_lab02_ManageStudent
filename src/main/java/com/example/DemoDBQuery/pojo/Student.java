package com.example.DemoDBQuery.pojo;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long Code;

    @Column(name = "name")
    private String Name;

    @Column(name = "username")
    private String Username;

    @Column(name = "password")
    private String password;

    @Column(name = "status")
    private boolean status;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Subjects> subjects;

    public Student() {
    }

    public Student(long code, String name, String username, String password, boolean status, List<Subjects> subjects) {
        Code = code;
        Name = name;
        Username = username;
        this.password = password;
        this.status = status;
        this.subjects = subjects;
    }

    public Student(String name, String username, String password, List<Subjects> subjects) {
        Name = name;
        Username = username;
        this.password = password;
        this.status = true;
        this.subjects = subjects;
    }

    public Student(String name, String username, String password) {
        Name = name;
        Username = username;
        this.password = password;
        this.status = true;
    }

    public long getCode() {
        return Code;
    }

    public void setCode(long code) {
        Code = code;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public List<Subjects> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subjects> subjects) {
        this.subjects = subjects;
    }
}
