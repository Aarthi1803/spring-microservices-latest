package com.telusko.service;


import com.telusko.dao.QuestionDao;
import com.telusko.dao.QuizDao;
import com.telusko.model.Question;
import com.telusko.model.QuestionWrapper;
import com.telusko.model.Quiz;
import com.telusko.model.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class QuizService {

    @Autowired
    QuizDao quizDao;
    
    @Autowired
    QuestionDao questionDao;


    public ResponseEntity<String> createQuiz(String category, int numberOfQuestions, String quizTitle) {

        List<Question> questions = questionDao.findRandomQuestionsByCategory(category);
        
     // Ensure we actually store the limited list
        List<Question> limitedQuestions = questions.stream()
        		 									.limit(numberOfQuestions)
        		 									.collect(Collectors.toList()); // fetch random records using JPA Native Query and limit number of rows to be returned in Java. As I got error in Native Query for LIMIT - @Query(value = "SELECT * FROM question q Where q.category=:category ORDER BY RANDOM() LIMIT :numQ", nativeQuery = true), This java code ensures that LIMIT in JPA Native Query does not cause issues.
        
        Quiz quiz = new Quiz();
        quiz.setQuizTitle(quizTitle);
        quiz.setQuestions(limitedQuestions);
        quizDao.save(quiz);

        return new ResponseEntity<>(" Added Quiz Successfully ", HttpStatus.CREATED);

    }

    /* SQL queries for createQuiz method:
        Hibernate: SELECT * FROM question q Where q.category = ? ORDER BY RAND()
		Hibernate: insert into quiz (question_title) values (?)
		Hibernate: insert into quiz_questions (quiz_quiz_id,questions_question_id) values (?,?)
		Hibernate: insert into quiz_questions (quiz_quiz_id,questions_question_id) values (?,?)
		Hibernate: insert into quiz_questions (quiz_quiz_id,questions_question_id) values (?,?)
		Hibernate: insert into quiz_questions (quiz_quiz_id,questions_question_id) values (?,?)
		Hibernate: insert into quiz_questions (quiz_quiz_id,questions_question_id) values (?,?)
     */
    
    
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer quizId) {
        Optional<Quiz> quiz = quizDao.findById(quizId);
        if (!quiz.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        List<Question> questionsFromQuizDB = quiz.get().getQuestions();
        List<QuestionWrapper> questionsForUser = new ArrayList<>();
        for(Question q : questionsFromQuizDB){ // Convert Question objects to QuestionWrapper objects before returning them
            QuestionWrapper qw = new QuestionWrapper(q.getQuestionId(), q.getQuestionTitle(), q.getOption1(), q.getOption2(), q.getOption3(), q.getOption4());
            questionsForUser.add(qw);
        }

        return new ResponseEntity<>(questionsForUser, HttpStatus.OK);

    }
    
    /* 
        SQL queries for getQuizQuestions method
     	Hibernate: select q1_0.quiz_id,q1_0.question_title from quiz q1_0 where q1_0.quiz_id=?
		Hibernate: 
		select 
		q1_0.quiz_quiz_id,
		q1_1.question_id,
		q1_1.category,
		q1_1.difficulty_level,
		q1_1.option1,
		q1_1.option2,
		q1_1.option3,
		q1_1.option4,
		q1_1.question_title,
		q1_1.right_answer 
		from quiz_questions q1_0 join question q1_1 
		on q1_1.question_id=q1_0.questions_question_id where q1_0.quiz_quiz_id=?
     */

    public ResponseEntity<Integer> calculateResult(Integer quizId, List<UserResponse> userResponses) {
        Quiz quiz = quizDao.findById(quizId).get(); // or Optional<Quiz> quiz = quizDao.findById(id); either use get() or use OptionalClass
        List<Question> questions = quiz.getQuestions();
        int totalRightAnswers = 0;
        int i = 0;
        for(UserResponse response : userResponses){
            if(response.getUserSelectedResponse().equals(questions.get(i).getRightAnswer()))
            	totalRightAnswers++;
            i++;
        }
        return new ResponseEntity<>(totalRightAnswers, HttpStatus.OK);
    }
    
    /* 
	    SQL queries for calculateResult method
	 	Hibernate: select q1_0.quiz_id,q1_0.question_title from quiz q1_0 where q1_0.quiz_id=?
		Hibernate: 
		select 
		q1_0.quiz_quiz_id,
		q1_1.question_id,
		q1_1.category,
		q1_1.difficulty_level,
		q1_1.option1,
		q1_1.option2,
		q1_1.option3,
		q1_1.option4,
		q1_1.question_title,
		q1_1.right_answer 
		from quiz_questions q1_0 join question q1_1 
		on q1_1.question_id=q1_0.questions_question_id where q1_0.quiz_quiz_id=?
   */
}
