package com.telusko.model;

import lombok.Data;

@Data
public class QuizDto {
    String categoryName;
    Integer numberOfQuestions;
    String quizTitle;
}
