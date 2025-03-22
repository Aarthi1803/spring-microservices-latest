package com.telusko.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.telusko.model.QuestionWrapper;
import com.telusko.model.UserResponse;
import com.telusko.service.QuizService;

@RestController
@RequestMapping("/quiz")
public class QuizController {

    @Autowired
    QuizService quizService;

//    @PostMapping("/createQuiz")
//    public ResponseEntity<String> createQuiz( @RequestParam String category, @RequestParam("numQuestions") int numQ, @RequestParam String title) {
//        return new ResponseEntity<>("Quiz creation initiated", HttpStatus.OK);
//    }
    
    @PostMapping("/createQuiz") // /quiz/create?category=Java&numberOfQuestions=5&quizTitle=JQuiz
    public ResponseEntity<String> createQuiz(@RequestParam String category, @RequestParam int numberOfQuestions, @RequestParam String quizTitle){ // @RequestParam` – Extracts parameters from the request URL
        return quizService.createQuiz(category, numberOfQuestions, quizTitle);
    }
    
    @GetMapping("/getQuizQuestions/{quizId}")
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable Integer quizId){
        return quizService.getQuizQuestions(quizId);
    }

    @PostMapping("/submitQuiz/{quizId}")
    public ResponseEntity<Integer> submitQuiz(@PathVariable Integer quizId, @RequestBody List<UserResponse> userResponses){
        return quizService.calculateResult(quizId, userResponses);
    }


}
