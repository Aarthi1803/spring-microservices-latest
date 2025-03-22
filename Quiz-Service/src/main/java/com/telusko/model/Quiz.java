package com.telusko.model;

import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer quizId;
    private String quizTitle;

    @ElementCollection // Creates a separate table "quiz_question_ids"to store List of question IDs.
    private List<Integer> questionIds;

}

/*
	Explanation of `@ElementCollection` in the Given Code:
	The given code defines a `Quiz` entity where the `questionIds` list is annotated with `@ElementCollection`. 
	This means that Hibernate will store these question IDs in a separate table "quiz_question_ids" instead of embedding them inside the main `Quiz` table.
	
	---
	
	1. Code Breakdown:
	
	@Entity // Marks this class as a JPA entity, meaning it maps to a database table.
	@Data  // Lombok annotation to automatically generate getters, setters, toString, equals, and hashCode methods.
	public class Quiz {
	
	    @Id // Marks quizId as the primary key.
	    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-generates the primary key.
	    private Integer quizId;
	
	    private String quizTitle; // Column to store quiz title.
	
	    @ElementCollection // Creates a separate table "quiz_question_ids" to store List of question IDs.
	    private List<Integer> questionIds; // Stores multiple question IDs.
	
	}
	
	---
	
	2. What Happens Internally?
	- `@ElementCollection` tells Hibernate that `question_ids` is a collection of basic values (`Integer` in this case).
	- Instead of storing the list inside the `Quiz` table, Hibernate will create a separate table "quiz_question_ids" to store the question IDs.
	- This separate table "quiz_question_ids" will have:
	  - A foreign key reference `"quiz_quiz_id" to the `Quiz` entity (`quiz_id`).
	  - A column "question_ids" for each question ID.
	
	---
	
	3. Table Structure in Database:
	After running this entity in a Spring Boot JPA application, Hibernate will create two tables:
	
	#Table 1: `quiz` (Main Table):
	| quiz_id | quiz_title  |
	|---------|-------------|
	| 1       | Java Quiz   |
	| 2       | Python Quiz |
	
	#Table 2: `quiz_question_ids` (Created Due to `@ElementCollection`):
	| quiz_quiz_id | question_ids |
	|------------- |------------- |
	| 1            | 101          |
	| 1            | 102          |
	| 1            | 103          |
	| 2            | 201          |
	| 2            | 202          |
	
	> Note:  
	> - The `quiz_quiz_id` column acts as a foreign key linking the questions to their respective quizzes.  
	> - The `question_ids` column stores multiple IDs associated with each quiz.
	
	---
	
	4. How Data is Stored and Retrieved:
	#Saving a Quiz with Questions
	
	@Autowired
	private QuizRepository quizRepository;
	
	public void createQuiz() {
	    Quiz quiz = new Quiz();
	    quiz.setQuizTitle("Spring Boot Quiz");
	    quiz.setQuestionIds(Arrays.asList(101, 102, 103)); // Assigning multiple question IDs
	
	    quizRepository.save(quiz);
	}
	```
	
	#Fetching a Quiz and Its Questions:
	Quiz quiz = quizRepository.findById(1).get();
	System.out.println("Quiz Title: " + quiz.getQuizTitle());
	System.out.println("Question IDs: " + quiz.getQuestionIds());
	
	##Output:
	Quiz Title: Spring Boot Quiz
	Question IDs: [101, 102, 103]
	
	
	---
	
	5. Important Points:
	1. Why `@ElementCollection`?
	   - Because `questionIds` is a list of primitive values (`Integer`), not an entity.
	   - Hibernate needs a separate table to store this collection.
	
	2. What Does `@ElementCollection` Do?
	   - It creates a separate table to store the list of question IDs.
	   - It automatically manages the relationship between `Quiz` and `questionIds`.
	
	3. Can We Use `@OneToMany` Instead?
	   - No, because `@OneToMany` is for entity relationships.  
	   - Here, `questionIds` is a list of integers, not an entity.
	
	---
	
	6. Customizing the Table Name (Optional):
	By default, Hibernate names the table as `quiz_question_ids`. You can customize it using `@CollectionTable`:
	
	@ElementCollection
	@CollectionTable(name = "quiz_questions", joinColumns = @JoinColumn(name = "quiz_id"))
	@Column(name = "question_id")
	private List<Integer> questionIds;
	
	Now, the new table will be:
	
	#Table: `quiz_questions`
	| quiz_id | question_id |
	|---------|------------ |
	| 1       | 101         |
	| 1       | 102         |
	| 1       | 103         |
	
	---
	
	7. When to Use `@ElementCollection`?
	✅ When storing primitive lists (e.g., `List<Integer>`, `List<String>`)  
	✅ When storing Embeddable objects (e.g., a list of `Address` objects)  
	✅ When you don't need a separate entity for the collection  
	
	---
	
	Conclusion
	- `@ElementCollection` helps store lists of basic values in a separate table.
	- It automatically creates the necessary mapping and manages relationships.
	- It is not meant for entity-to-entity relationships (`@OneToMany` should be used in that case).
	
*/