package com.telusko.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.telusko.model.Question;
import com.telusko.model.QuestionWrapper;
import com.telusko.model.UserResponse;
import com.telusko.service.QuestionService;

@RestController
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @Autowired
    Environment environment;

    @GetMapping("/allQuestions")
    public ResponseEntity<List<Question>> getAllQuestions(){
        return questionService.getAllQuestions();
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<Question>> getQuestionsByCategory(@PathVariable String category){ // {category} in the URL is mapped to the method parameter using @PathVariable
        return questionService.getQuestionsByCategory(category);
    }

    @PostMapping("/addQuestion")
    public ResponseEntity<String> addQuestion(@RequestBody Question question){ // @RequestBody annotation automatically converts the incoming JSON request into a Question object.
        return  questionService.addQuestion(question);
    }

    @DeleteMapping("/deleteQuestion/{questionId}")
    public ResponseEntity<String> getQuestionsByCategory(@PathVariable Integer questionId){ 
        return questionService.deleteQuestionById(questionId);
    }
    
    @PutMapping("/updateQuestion/{questionId}")
    public ResponseEntity<Question> updateQuestion(@PathVariable Integer questionId, @RequestBody Question updatedQuestion) {
        return questionService.updateQuestion(questionId, updatedQuestion);
    }

    @PatchMapping("/partialUpdateQuestion/{questionId}")
    public ResponseEntity<Question> partialUpdateRightAnswer(@PathVariable Integer questionId, @RequestBody Question updatedQuestion) {
        return questionService.partialUpdateRightAnswer(questionId, updatedQuestion);
    }
    
    @GetMapping("/generateQuestions")
    public ResponseEntity<List<Integer>> getQuestionsForQuiz
            (@RequestParam String categoryName, @RequestParam Integer numberOfQuestions ){
        return questionService.getQuestionsForQuiz(categoryName, numberOfQuestions);
    }

    @PostMapping("/getQuestions")
    public ResponseEntity<List<QuestionWrapper>> getQuestionsFromId(@RequestBody List<Integer> questionIds){
        System.out.println(environment.getProperty("local.server.port")); // Fetches the running port
        return questionService.getQuestionsFromId(questionIds);
    }

    @PostMapping("/getTotalScore")
    public ResponseEntity<Integer> getScore(@RequestBody List<UserResponse> userResponses){
        return questionService.getScore(userResponses);
    }

}
    // generateQuestions
    // getQuestions (questionId)
    // getTotalScore


/*

Understanding `environment.getProperty("local.server.port")` in Spring Boot:

@PostMapping("/getQuestions")
public ResponseEntity<List<QuestionWrapper>> getQuestionsFromId(@RequestBody List<Integer> questionIds) {
    System.out.println(environment.getProperty("local.server.port"));  // Fetches the running port
    return questionService.getQuestionsFromId(questionIds);
}


#What does `environment.getProperty("local.server.port")` do?
1. The `environment` object in Spring Boot fetches configuration properties from `application.properties` or `application.yml`.  
2. `environment.getProperty("local.server.port")` retrieves the current running server port.  
3. If the port is not explicitly set in `application.properties`, Spring Boot will assign a random available port (if `server.port=0` is set).  
4. This is useful for debugging, logging, or dynamically adjusting configurations based on the running port.

---

Where is `environment` Defined?
Typically in a Spring Boot application, it is injected using:


import org.springframework.core.env.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/questions")
public class QuestionController {

    @Autowired
    private Environment environment;  // Inject Spring Environment

    @PostMapping("/getQuestions")
    public ResponseEntity<List<QuestionWrapper>> getQuestionsFromId(@RequestBody List<Integer> questionIds) {
        System.out.println(environment.getProperty("local.server.port")); // Prints the running port
        return questionService.getQuestionsFromId(questionIds);
    }
}

---

Example Usage:
#1️. Set the Port in `application.properties`: server.port=8085

If you start the Spring Boot application, it will always run on port 8085, and this statement: 
System.out.println(environment.getProperty("local.server.port"));

Will print: 8085

---

#2️. Random Port Allocation (if `server.port=0`) : server.port=0

- When you run the application, Spring Boot will pick a random available port.
- Suppose Spring Boot starts on port 50324, then:

System.out.println(environment.getProperty("local.server.port"));

Will print: 50324

This is useful for microservices where each instance runs on a different port.

---

Why Use `environment.getProperty("local.server.port")`?
✅ For Logging – Helps in debugging by printing the running port.  
✅ For Dynamic Configuration – Useful in cases where port-based decisions need to be made.  
✅ For Microservices – When running multiple instances dynamically (with `server.port=0`).  

---

Final Thoughts
- `environment.getProperty("local.server.port")` is a dynamic way to fetch the running port in a Spring Boot application.  
- It is especially useful when using random ports or when debugging microservices.  
- Ensure that `environment` is properly injected into the controller.

*/