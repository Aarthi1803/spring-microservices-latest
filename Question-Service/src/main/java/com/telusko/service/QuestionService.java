package com.telusko.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.telusko.dao.QuestionDao;
import com.telusko.model.Question;
import com.telusko.model.QuestionWrapper;
import com.telusko.model.UserResponse;

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
   
   public ResponseEntity<List<Integer>> getQuestionsForQuiz(String categoryName, Integer numberOfQuestions) {
       List<Integer> questions = questionDao.findRandomQuestionsByCategory(categoryName);
       
    // Ensure we actually store the limited list
       List<Integer> limitedQuestions = questions.stream()
       		 									 .limit(numberOfQuestions)
       		 									 .collect(Collectors.toList()); // fetch random records using JPA Native Query and limit number of rows to be returned in Java. As I got error in Native Query for LIMIT - @Query(value = "SELECT * FROM question q Where q.category=:category ORDER BY RANDOM() LIMIT :numQ", nativeQuery = true), This java code ensures that LIMIT in JPA Native Query does not cause issues.
      
       return new ResponseEntity<>(limitedQuestions, HttpStatus.OK);
   }

   public ResponseEntity<List<QuestionWrapper>> getQuestionsFromId(List<Integer> questionIds) {
       List<QuestionWrapper> wrappers = new ArrayList<>();
       List<Question> questions = new ArrayList<>();

       for(Integer id : questionIds){
           questions.add(questionDao.findById(id).get());
       }

//       for(Question question : questions){ // Convert Question objects to QuestionWrapper objects before returning them
//           QuestionWrapper wrapper = new QuestionWrapper();
//           wrapper.setQuestionId(question.getQuestionId());
//           wrapper.setQuestionTitle(question.getQuestionTitle());
//           wrapper.setOption1(question.getOption1());
//           wrapper.setOption2(question.getOption2());
//           wrapper.setOption3(question.getOption3());
//           wrapper.setOption4(question.getOption4());
//           wrappers.add(wrapper);
//       }

       for(Question q : questions){ // Convert Question objects to QuestionWrapper objects before returning them
           QuestionWrapper qw = new QuestionWrapper(q.getQuestionId(), q.getQuestionTitle(), q.getOption1(), q.getOption2(), q.getOption3(), q.getOption4());
           wrappers.add(qw);
       }
       
       return new ResponseEntity<>(wrappers, HttpStatus.OK);
   }

   public ResponseEntity<Integer> getScore(List<UserResponse> userResponses) {

       int totalRightAnswers = 0;

       for(UserResponse response : userResponses){
           Question question = questionDao.findById(response.getQuestionId()).get();
           if(response.getUserSelectedResponse().equals(question.getRightAnswer()))
        	   totalRightAnswers++;
       }
       return new ResponseEntity<>(totalRightAnswers, HttpStatus.OK);
   }
   
}
