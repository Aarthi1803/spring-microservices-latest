package com.telusko.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;

@Entity
@Data
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer quizId;
    private String quizTitle;

    @ManyToMany // One quiz has multiple questions (One-to-Many relationship). The same question can be part of multiple quizzes (Many-to-Many relationship). We must implement a Many-to-Many mapping, which requires an extra table to map quizzes and their corresponding questions.
    private List<Question> questions;

}
