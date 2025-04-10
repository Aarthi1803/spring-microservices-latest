package com.telusko.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.telusko.model.Question;

@Repository
public interface QuestionDao extends JpaRepository<Question, Integer> {

    List<Question> findByCategory(String category);

    @Query(value = "SELECT q.question_id FROM question q Where q.category = :category ORDER BY RAND()", nativeQuery = true)
    List<Integer> findRandomQuestionsByCategory(String category);
}
