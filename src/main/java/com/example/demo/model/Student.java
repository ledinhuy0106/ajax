package com.example.demo.model;

import javax.persistence.*;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double score;
    private int age;
    @ManyToOne
    @JoinColumn(name = "clazz_id")
    private Clazz clazz;

    public Student(Long id, String name, double score, int age, Clazz clazz) {
        this.id = id;
        this.name = name;
        this.score = score;
        this.age = age;
        this.clazz = clazz;
    }

    public Student(String name, double score, int age, Clazz clazz) {
        this.name = name;
        this.score = score;
        this.age = age;
        this.clazz = clazz;
    }

    public Student() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Clazz getclazz() {
        return clazz;
    }

    public void setclazz(Clazz clazz) {
        this.clazz = clazz;
    }
}
