package com.telusko.service;


import com.telusko.dao.QuizDao;
import com.telusko.feign.QuizInterface;
import com.telusko.model.QuestionWrapper;
import com.telusko.model.Quiz;
import com.telusko.model.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizService {

    @Autowired
    QuizDao quizDao;

    @Autowired
    QuizInterface quizInterface;


    public ResponseEntity<String> createQuiz(String categoryName, int numberOfQuestions, String title) {

        List<Integer> questions = quizInterface.getQuestionsForQuiz(categoryName, numberOfQuestions).getBody();
        Quiz quiz = new Quiz();
        quiz.setQuizTitle(title);
        quiz.setQuestionIds(questions);
        quizDao.save(quiz);

        return new ResponseEntity<>("Quiz Successfully Created ", HttpStatus.CREATED);

    }

    /* SQL queries for createQuiz method:
        Hibernate: SELECT q.question_id FROM question q Where q.category = ? ORDER BY RAND()
        Hibernate: select q1_0.quiz_id,q1_0.quiz_title from quiz q1_0 where q1_0.quiz_id=?
		Hibernate: select qi1_0.quiz_quiz_id,qi1_0.question_ids from quiz_question_ids qi1_0 where qi1_0.quiz_quiz_id=?
		Hibernate: insert into quiz (quiz_title) values (?)
		Hibernate: insert into quiz_question_ids (quiz_quiz_id,question_ids) values (?,?)
		Hibernate: insert into quiz_question_ids (quiz_quiz_id,question_ids) values (?,?)
		Hibernate: insert into quiz_question_ids (quiz_quiz_id,question_ids) values (?,?)
		Hibernate: insert into quiz_question_ids (quiz_quiz_id,question_ids) values (?,?)
		Hibernate: insert into quiz_question_ids (quiz_quiz_id,question_ids) values (?,?)
     */
    
    
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer quizId) {
    	
        Quiz quiz = quizDao.findById(quizId).get();
        List<Integer> questionIds = quiz.getQuestionIds();
        ResponseEntity<List<QuestionWrapper>> questions = quizInterface.getQuestionsFromId(questionIds);
        return questions;

    }
    
    /* 
        SQL queries for getQuizQuestions method
     	Hibernate: 
		select q1_0.question_id,
		q1_0.category,
		q1_0.difficulty_level,
		q1_0.option1,
		q1_0.option2,
		q1_0.option3,
		q1_0.option4,
		q1_0.question_title,
		q1_0.right_answer from question q1_0 where q1_0.question_id=?
		Hibernate: 
		select q1_0.question_id,
		q1_0.category,
		q1_0.difficulty_level,
		q1_0.option1,
		q1_0.option2,
		q1_0.option3,
		q1_0.option4,
		q1_0.question_title,
		q1_0.right_answer from question q1_0 where q1_0.question_id=?
		Hibernate: 
		select q1_0.question_id,
		q1_0.category,
		q1_0.difficulty_level,
		q1_0.option1,
		q1_0.option2,
		q1_0.option3,
		q1_0.option4,
		q1_0.question_title,
		q1_0.right_answer from question q1_0 where q1_0.question_id=?
    */

    public ResponseEntity<Integer> calculateResult(Integer quizId, List<UserResponse> userResponses) {
        ResponseEntity<Integer> score = quizInterface.getScore(userResponses);
        return score;
    }
    
    /* 
	    SQL queries for calculateResult method
	 	Hibernate: 
		select q1_0.question_id,
		q1_0.category,
		q1_0.difficulty_level,
		q1_0.option1,
		q1_0.option2,
		q1_0.option3,
		q1_0.option4,
		q1_0.question_title,
		q1_0.right_answer from question q1_0 where q1_0.question_id=?
		Hibernate: 
		select q1_0.question_id,
		q1_0.category,
		q1_0.difficulty_level,
		q1_0.option1,
		q1_0.option2,
		q1_0.option3,
		q1_0.option4,
		q1_0.question_title,
		q1_0.right_answer from question q1_0 where q1_0.question_id=?
		Hibernate: 
		select q1_0.question_id,
		q1_0.category,
		q1_0.difficulty_level,
		q1_0.option1,
		q1_0.option2,
		q1_0.option3,
		q1_0.option4,
		q1_0.question_title,
		q1_0.right_answer from question q1_0 where q1_0.question_id=?

   */
}
