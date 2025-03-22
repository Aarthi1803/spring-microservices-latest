package com.telusko.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.telusko.model.Question;
import com.telusko.service.QuestionService;

@RestController
@RequestMapping("/question")
public class QuestionController {

	@Autowired
    QuestionService questionService;

//	@GetMapping("/allQuestions")
//	public List<Question> getAllQuestions() {
//	    return questionService.getAllQuestions();
//	}
	
//	@GetMapping("/allQuestions")
//	public ResponseEntity<List<Question>> getAllQuestions() {
//	    return new ResponseEntity<>(questionService.getAllQuestions(), HttpStatus.OK);
//	}

	
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
 
    @PostMapping("/addQuestion1")
    public ResponseEntity<Question> addQuestion1(@RequestBody Question question){
        return  questionService.addQuestion1(question);
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

    
}
