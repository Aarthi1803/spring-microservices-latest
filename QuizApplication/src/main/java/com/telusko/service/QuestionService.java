package com.telusko.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.telusko.dao.QuestionDao;
import com.telusko.model.Question;

@Service
public class QuestionService {
	
    @Autowired
    QuestionDao questionDao;

//    public List<Question> getAllQuestions() {
//        return questionDao.findAll();
//    }
    
    public ResponseEntity<List<Question>> getAllQuestions() {
    	
        try {
            return new ResponseEntity<>(questionDao.findAll(), HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
        
    }

    public ResponseEntity<List<Question>> getQuestionsByCategory(String category) {
    	
        try {
            return new ResponseEntity<>(questionDao.findByCategory(category), HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
        
    }

//    public String addQuestion(Question question) {
//        questionDao.save(question);
//        return "Success";
//    }

    
    public ResponseEntity<String> addQuestion(Question question) {
    	
    	try {
    		questionDao.save(question);
    		return new ResponseEntity<>(" Added Question Successfully ", HttpStatus.CREATED);
    	}catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(" Failure in Adding Question ", HttpStatus.BAD_REQUEST);
        
    }
    
   public ResponseEntity<Question> addQuestion1(Question question) {
    	
    	try {
    		questionDao.save(question);
    		return new ResponseEntity<>(question, HttpStatus.CREATED);
    	}catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        
    }

   public ResponseEntity<String> deleteQuestionById(Integer questionId) {
	   
	   try {
   			questionDao.deleteById(questionId);
   			return new ResponseEntity<>(" Deleted Question Successfully ", HttpStatus.OK);
   	   }catch (Exception e){
            e.printStackTrace();
       }
       return new ResponseEntity<>(" Failure in Deleting Question ", HttpStatus.BAD_REQUEST);
       
   }
    
   
   public ResponseEntity<Question> updateQuestion(Integer questionId, Question updatedQuestion) {
	   
       Optional<Question> existingQuestion = questionDao.findById(questionId);
       if (existingQuestion.isPresent()) {
           Question question = existingQuestion.get();
           question.setQuestionTitle(updatedQuestion.getQuestionTitle());
           question.setOption1(updatedQuestion.getOption1());
           question.setOption2(updatedQuestion.getOption2());
           question.setOption3(updatedQuestion.getOption3());
           question.setOption4(updatedQuestion.getOption4());
           question.setRightAnswer(updatedQuestion.getRightAnswer());
           question.setDifficultyLevel(updatedQuestion.getDifficultyLevel());
           question.setCategory(updatedQuestion.getCategory());
           questionDao.save(question);
           return ResponseEntity.ok(question); // or return new ResponseEntity<>(question , HttpStatus.OK);
       } else {
           return ResponseEntity.notFound().build(); // or return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
       }
       
   }
   
   public ResponseEntity<Question> partialUpdateRightAnswer(Integer questionId, Question updatedQuestion) {
	    Optional<Question> existingQuestion = questionDao.findById(questionId);
	    
	    if (existingQuestion.isPresent()) {
	        Question question = existingQuestion.get();
	        question.setRightAnswer(updatedQuestion.getRightAnswer());;
	        questionDao.save(question);
	        return ResponseEntity.ok(question);
	    } else {
	        return ResponseEntity.notFound().build();
	    }
	}

}
