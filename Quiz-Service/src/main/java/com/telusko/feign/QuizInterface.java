package com.telusko.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.telusko.model.QuestionWrapper;
import com.telusko.model.UserResponse;

@FeignClient("QUESTION-SERVICE")
public interface QuizInterface {
	
    @GetMapping("/question/generateQuestions")
    public ResponseEntity<List<Integer>> getQuestionsForQuiz
            (@RequestParam String categoryName, @RequestParam Integer numberOfQuestions );

    @PostMapping("/question/getQuestions")
    public ResponseEntity<List<QuestionWrapper>> getQuestionsFromId(@RequestBody List<Integer> questionIds);

    @PostMapping("/question/getTotalScore")
    public ResponseEntity<Integer> getScore(@RequestBody List<UserResponse> userResponses);

}