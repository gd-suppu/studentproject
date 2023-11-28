package com.studentdemoproject.studentdemoproject.model;

import jakarta.persistence.*;

@Entity
@Table(name="student")
public class Student {
    Student(){
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name="name")
    private String name;

    @Column(name="test_Score")
    private Integer testScore;

    public Student(Long id, String name, Integer testScore) {
        this.id = id;
        this.name = name;
        this.testScore = testScore;
        if (testScore < 0 || testScore > 100) {
            throw new IllegalArgumentException("Test score must be in bounds between 0 and 100");
        }
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

    public Integer getTestScore() {
        return testScore;
    }

    public void setTestScore(Integer testScore) {
        this.testScore = testScore;
    }
}
