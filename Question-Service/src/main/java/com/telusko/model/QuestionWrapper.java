package com.telusko.model;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class QuestionWrapper { // We must not expose the correct answer to the client, as this would compromise the quiz. Instead, we create a wrapper class to exclude the correct answer. To prevent exposing sensitive data, we introduce a new class: QuestionWrapper. Now, instead of returning a List of Question objects, our API returns a List of QuestionWrapper objects, ensuring that answers remain hidden.

    private Integer questionId;
    private String questionTitle;
    private String option1;
    private String option2;
    private String option3;
    private String option4;

    public QuestionWrapper(Integer questionId, String questionTitle, String option1, String option2, String option3, String option4) {
        this.questionId = questionId;
        this.questionTitle = questionTitle;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
    }
    
}