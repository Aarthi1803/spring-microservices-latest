package com.telusko.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.telusko.model.Question;

@Repository
public interface QuestionDao extends JpaRepository<Question, Integer> {

    List<Question> findByCategory(String category);

    @Query(value = "SELECT * FROM question q Where q.category = :category ORDER BY RAND()", nativeQuery = true)
    List<Question> findRandomQuestionsByCategory(String category);
}

/*
	Breaking Down the Query: @Query(value = "SELECT * FROM question q WHERE q.category = :category ORDER BY RAND()", nativeQuery = true)

    @Query --> This annotation is used to define a custom query in a Spring Data JPA repository.
    value = "SELECT * FROM question q WHERE q.category = :category ORDER BY RAND()" --> This is a native SQL query.
    nativeQuery = true --> It tells Spring Data JPA that we are using a raw SQL query, not JPQL (Java Persistence Query Language).
    :category --> This is a named parameter. The value for category will be passed as a method argument.
    ORDER BY RAND() --> This ensures that the results are returned in a random order.
*/