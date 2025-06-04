package com.example.DemoDBQuery.pojo;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;
    @Column(name = "cat_name")
    private String catName;
    @Column(name = "url")
    private String url;
    @ManyToMany(mappedBy = "categories")
    private List<Subjects> subjects;

    public Category() {
    }

    public Category(long id, String catName, String url, List<Subjects> subjects) {
        this.id = id;
        this.catName = catName;
        this.url = url;
        this.subjects = subjects;
    }

    public Category(String catName, String url, List<Subjects> subjects) {
        this.catName = catName;
        this.url = url;
        this.subjects = subjects;
    }

    public Category(String catName, String url) {
        this.catName = catName;
        this.url = url;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<Subjects> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subjects> subjects) {
        this.subjects = subjects;
    }
}
