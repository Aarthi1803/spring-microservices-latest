What are Microservices
=========================
Microservices represent a modern approach to software development, addressing the challenges posed by traditional monolithic architectures. 
To understand the necessity of microservices, let's first examine the evolution of software systems.

Evolution of Software Development:
In the 1970s, computers were primarily used for scientific and research purposes. 
As technology evolved, businesses started leveraging software for commercial use in the 1990s. 
By the early 2000s, the rise of social media and e-commerce platforms like Amazon transformed the digital landscape. 
Today, software applications facilitate almost every aspect of daily life, from booking a cab to online shopping and financial transactions.

Traditional Approach: Monolithic Architecture

Traditionally, software applications were developed as a single, unified system, known as monolithic architecture. 
A monolithic application includes all features and services within a single codebase. 
For instance, an e-commerce platform like Amazon incorporates search functionality, product listings, payment processing, 
and seller management within one large system.

# Advantages of Monolithic Architecture:
1. Unified Codebase – All functionalities reside in a single package, making deployment straightforward.
2. Easier Development – Developers can maintain a single code repository.
3. Simplified Debugging – Issues can be identified and fixed within a centralized system.

# Drawbacks of Monolithic Architecture:
1. Team Dependencies – Large teams working on a single codebase lead to interdependencies and bottlenecks during deployment.
2. Scalability Issues – Scaling specific features requires scaling the entire application, leading to inefficient resource utilization.
3. Technology Constraints – The entire system is typically built using a single technology stack, limiting flexibility.
4. Deployment Challenges – Updating or adding features necessitates redeploying the entire application, increasing downtime and risks.
5. Failure Impact – A failure in one module can crash the entire application, making maintenance complex.

Microservices Approach:

Microservices architecture addresses these challenges by breaking down an application into smaller, independent services, 
each handling a specific function. In the case of an e-commerce platform like Amazon:
- Search Service – Manages product searches.
- Cart Service – Handles adding and removing items from the cart.
- Payment Service – Processes online transactions.
- User Service – Manages user accounts and authentication.

Each microservice is self-contained, can be deployed independently, and can scale as needed.

# Advantages of Microservices:
1. Independent Development – Teams can develop, deploy, and maintain different services without interfering with others.
2. Scalability – Instead of scaling the entire application, only the required services can be scaled based on demand 
(e.g., during a sales event, only the payment and search services may need scaling).
3. Technology Diversity – Different services can be built using different programming languages and frameworks.
4. Fault Isolation – If one microservice fails, it does not bring down the entire application.
5. Faster Deployment – Smaller, modular updates allow for continuous integration and delivery.

# Challenges of Microservices:
1. Service Communication – Microservices need a mechanism to communicate, often using HTTP APIs or message brokers.
2. Service Discovery – Locating services dynamically within the architecture requires a registry system.
3. API Gateway Management – A central API Gateway manages requests between services.
4. Data Management – Distributed databases require careful synchronization and consistency.
5. Security Considerations – Each service must implement authentication and authorization mechanisms.

Communication Between Microservices:
Microservices interact using:
- HTTP Requests/Responses – RESTful APIs enable communication between services.
- Message Brokers – Systems like Kafka or RabbitMQ handle asynchronous messaging.
- Service Discovery – Tools like Eureka help services locate each other dynamically.

Conclusion:
Microservices provide a robust, scalable, and flexible approach to software development, making them ideal for large-scale applications. 
While they introduce complexity in communication and management, their benefits far outweigh the challenges, 
making them the preferred choice for enterprises like Amazon, Netflix, and Uber. Implementing microservices successfully requires 
thoughtful architecture planning, appropriate technology choices, and efficient service orchestration.


------
Microservices are an architectural style for developing software systems that are made up of small, 
independently deployable services that work together to provide a larger functionality. 
Each microservice is designed to perform a specific task or function and communicates with other microservices via APIs or messaging protocols.

In a microservices architecture, the application is broken down into a collection of loosely coupled services, 
each running in its own process and communicating with each other through lightweight mechanisms, such as HTTP or messaging protocols. 
This approach allows each service to be developed, deployed, and scaled independently, which can result in faster time-to-market, 
improved scalability, and better fault tolerance.

Microservices can be implemented using a variety of programming languages and frameworks, and can be deployed on different platforms, 
such as on-premise servers, cloud infrastructure, or containers. 
However, designing and managing a microservices architecture requires careful consideration of factors such as service boundaries, 
data consistency, service discovery, and API design, among others.

-----------------------------------------------------------------------------------------------------
Blue-Green Deployment: A Simple and Detailed Explanation:
============================================================

What is Blue-Green Deployment?
Blue-Green Deployment is a deployment strategy that helps reduce downtime and risk when releasing new versions of an application. 
It achieves this by maintaining two separate environments,Blue andGreen, where one serves live traffic while the other remains idle 
or is used for testing.

---

How Does Blue-Green Deployment Work?
Let's break it down step by step.

1.Two Identical Environments (Blue & Green)  
   -Blue Environment: This is the currently live version of your application that users are interacting with.
   -Green Environment: This is the new version of your application, which is fully tested and ready for deployment but not yet live.

2.Deploying the New Version in the Green Environment  
   - Developers deploy the updated application in theGreen environment while theBlue environment continues to handle real user traffic.
   - The Green environment is tested thoroughly to ensure the new version works correctly.

3.Switch Traffic from Blue to Green  
   - Once the new version is verified and works fine, a simpletraffic switch (load balancer update or DNS change) is performed.
   - Now, the Green environmentbecomes live, and users start using the new version.
   - The Blue environment iskept as a backup.

4.Rollback (If Needed)  
   - If something goes wrong with the new version (Green), the system canimmediately switch back to the old version (Blue), ensuring no downtime.

---

Example Scenario: E-Commerce Website
Imagine you have ane-commerce website running onBlue environment (current version). You want to release a new update with a better UI 
and faster checkout.

- You deploy the new version in theGreen environment and test it.
- Once testing is complete, youswitch user traffic to the Green environment.
- If users report issues, you can quickly switch back to theBlue environment with no downtime.

---

Benefits of Blue-Green Deployment
✅Zero Downtime – Users experience no interruptions.  
✅Instant Rollback – If something goes wrong, rollback is fast.  
✅Safe Testing – The new version is fully tested before going live.  
✅Continuous Delivery – Enables faster and more reliable deployments.  

---

Challenges of Blue-Green Deployment
❌Double Infrastructure Cost – Requires two identical environments.  
❌Database Changes Need Special Handling – If the database schema changes, rolling back may be difficult.  
❌Load Balancer Complexity – Requires proper traffic routing configuration.  

---

Conclusion
Blue-Green Deployment is a powerful deployment strategy that allows teams to release new features safely withminimal risk andzero downtime. 
By keeping abackup environment, businesses ensure a smooth user experience while rolling out updates.

------------------------------------
Blue-green deployment is a technique used in software development and deployment, where two identical production environments, 
typically referred to as "blue" and "green," are created. 
While one environment, say the blue environment, is serving live traffic, the other environment, the green environment, remains idle.

Once the green environment is fully deployed and tested, traffic is redirected from the blue environment to the green environment, 
making the green environment the new production environment. 
The blue environment is then kept idle, serving as a standby environment in case of any issues with the new environment.

The primary advantage of the blue-green deployment technique is that it allows for zero-downtime deployment of software updates or new releases. 
It also provides a quick and reliable way to roll back the deployment in case of any issues.

This technique is commonly used in environments that require high availability, such as web applications or e-commerce platforms, 
to ensure that the end-users experience minimal disruption during the deployment process.

------------------------------------------------------------------------------------------------------
Cloud Native vs Cloud Ready | 12 Factor App
===============================================

#Understanding Cloud-Based Applications:
Enterprise-level applications were traditionally hosted on-premises, where companies maintained their own servers for deployment. 
However, with advancements in cloud technology, most companies are migrating from on-premises infrastructure to the cloud, 
leveraging cloud-based services for better efficiency. 
Popular applications like Google Docs, Dropbox, and Gmail operate entirely on the cloud, and internal company applications are also transitioning.

When discussing cloud applications, two terms often arise: Cloud Ready and Cloud Native. 
Understanding their differences is crucial to optimizing cloud benefits, including cost savings, scalability, and reduced operational issues.

#Cloud Ready vs Cloud Native:

Cloud Ready Applications:
A cloud-ready application is an existing on-premises application that undergoes modifications to be hosted on the cloud. 
Simply transferring an application without adjustments will not work. Instead, the application must be adapted to be cloud-compatible by:
- Working with environment variables
- Configuring settings for cloud deployment
- Ensuring compatibility with cloud services
Thus, cloud-ready applications are essentially non-cloud applications that have been modified to function on the cloud.

Cloud Native Applications:
A cloud-native application, in contrast, is specifically designed for cloud environments from the start. 
If a new project is being developed with cloud deployment in mind, it should be built as cloud-native to fully leverage cloud features.

Cloud-native applications adhere to specific standards and best practices. 
One widely accepted framework is the 12 Factor App, established by Heroku. 
These principles ensure that applications are built for scalability, maintainability, and resilience in cloud environments.

---

The 12 Factor App Methodology:
The 12 Factor App methodology defines a set of best practices for developing modern cloud-native applications. 
These principles standardize development across teams and improve scalability, maintainability, and portability.

#1. Codebase:
A cloud-native application should have:
- A single codebase tracked in version control (e.g., Git)
- Multiple deployable instances (e.g., development, staging, production) originating from the same repository
Multiple applications should not share a single codebase, and one application should not have multiple codebases.

#2. Dependencies:
Dependencies should be explicitly declared and managed using dependency managers like Maven (for Java) instead of manually adding JAR files.
- This ensures consistent dependency versions across different environments.
- Dependency configuration should be maintained in a manifest file (e.g., `pom.xml` for Maven).

#3. Configuration:
Application configurations (e.g., database URLs, credentials, port numbers) should:
- Be stored in environment variables
- Not be hardcoded within the source code
- Allow easy modification without changing the source code

#4. Backing Services:
Applications often rely on backing services like databases, third-party APIs, or caching mechanisms. 
These should be treated as resources, enabling easy switching (e.g., switching from MySQL to PostgreSQL) without modifying the application code.

#5. Build, Release, Run:
A structured deployment workflow should be followed:
- Build: Compile and package the application (e.g., generate a JAR file in Java)
- Release: Apply environment-specific configurations and version control
- Run: Execute the application in a specified environment
This ensures rollback capabilities and prevents direct changes in production environments.

#6. Processes:
Cloud-native applications should be stateless:
- Avoid storing user sessions on servers
- Store persistent data in external databases
- Ensure seamless horizontal scaling by distributing load across multiple instances

#7. Port Binding:
Each service should be accessible via a specific port:
- HTTP services use port `80`
- Application services should expose their own unique ports (e.g., Microservices architecture assigns different ports to different services)

#8. Concurrency:
Instead of relying solely on multi-threading (vertical scaling), applications should support horizontal scaling:
- Deploy multiple instances across distributed servers
- Load balancers distribute traffic among instances

#9. Disposability:
Applications should be designed for quick startup and graceful shutdown:
- Ensure proper resource cleanup (e.g., closing database connections)
- Prevent data loss by persisting critical data before shutdown
- Handle failures gracefully

#10. Dev/Prod Parity:
Development, staging, and production environments should be as identical as possible:
- Use containerization (e.g., Docker) to standardize environments
- Automate deployments to reduce configuration drift

#11. Logs:
Applications should log their output as event streams:
- Logs should not be stored locally but instead sent to external log management services (e.g., ELK stack, Splunk)
- Helps in debugging and monitoring across multiple instances

#12. Admin Processes:
One-time admin tasks (e.g., database migrations, scheduled jobs) should be executed separately from the core application runtime:
- Example: Running database migration scripts before deploying new versions

---

Conclusion:
The 12 Factor App methodology provides a solid foundation for developing cloud-native applications that are scalable, maintainable, and portable. 
Understanding the distinction between cloud-ready and cloud-native applications helps businesses transition to the cloud effectively 
while leveraging the full potential of cloud services.

-----------------------------------------------------------------------------------------------------
Quiz App Project Setup (Part 1)
==========================================

Introduction:
In this microservices series, we will start by building a monolithic application and later transform it into a microservice-based architecture. The goal is to understand:
- How to create microservices.
- Technologies that facilitate microservices development.
- How microservices communicate with each other.

The example application will be simple, focusing more on tools rather than complexity.

---

Project Overview:
Initially, we are developing a monolithic quiz application where:
- Users will receive 10 multiple-choice questions (MCQs).
- Based on their answers, they will earn scores.
- The application will store around 10-15 questions in a MySQL database.
- We will build the backend using Spring Boot.
- CRUD operations (Create, Read, Update, Delete) will be implemented for question management.

---

Setting Up the Project:
To create a Spring Boot project, we use Spring Initializr:
1. Project Type: Maven
2. Language: Java (Alternative: Kotlin, Groovy)
3. Spring Boot Version: 3.1
4. Group ID: `com.telusko`
5. Artifact ID: `quiz-app`
6. Packaging: JAR
7. Java Version: 17

Dependencies:
- Spring Web (For building the REST API)
- Spring Data JPA (For database interaction)
- MySQL Driver (For connecting to MySQL)
- Lombok (To reduce boilerplate code, optional)

After selecting these dependencies, click Generate, download, and extract the project.

---

Importing the Project into an IDE
The project can be opened in any IDE:
- IntelliJ IDEA (Ultimate or Community Edition)
- Eclipse (STS)
- VS Code

Steps:
1. Open IntelliJ IDEA.
2. Click Open Project and select the extracted project folder.
3. Ensure that Maven dependencies are downloaded.

---

Configuring MySQL Database
After logging in:
1. Expand Databases and create a new database if necessary.
2. Ensure a questions table exists with columns:
   - `id` (Primary Key)
   - `category`
   - `difficulty_level`
   - `options` (Four options for MCQs)
   - `question_title`
   - `right_answer`

CREATE DATABASE questiondb;
use questiondb;
CREATE TABLE question
(
    id SERIAL PRIMARY KEY,
    question_title TEXT NOT NULL,
    option1 TEXT NOT NULL,
    option2 TEXT NOT NULL,
    option3 TEXT NOT NULL,
    option4 TEXT NOT NULL,
    right_answer TEXT NOT NULL,
    difficulty_level TEXT NOT NULL,
    category TEXT NOT NULL
);

INSERT INTO question 
	(category, difficulty_level, option1, option2, option3, option4, question_title, right_answer)
	VALUES 
	('Java', 'Easy', 'class', 'interface', 'extends', 'implements', 'Which Java keyword is used to create a subclass?', 'extends'),
	('Java', 'Easy', '4', '5', '6', 'Compile error', 'What is the output of the following Java code snippet? \nint x = 5; \nSystem.out.println(x++);', '5'),
	('Java', 'Easy', 'TRUE', 'FALSE', '0', 'null', 'In Java, what is the default value of an uninitialized boolean variable?', 'FALSE'),
	('Java', 'Easy', 'try', 'throw', 'catch', 'finally', 'Which Java keyword is used to explicitly throw an exception?', 'throw'),
	('Java', 'Easy', 'It indicates that a variable is constant.', 'It indicates that a method can be accessed without creating an instance of the class.', 'It indicates that a class cannot be extended.', 'It indicates that a variable is of primitive type.', 'What does the ''static'' keyword mean in Java?', 'It indicates that a method can be accessed without creating an instance of the class.'),
	('Java', 'Easy', 'constant int x = 5;', 'final int x = 5;', 'static int x = 5;', 'readonly int x = 5;', 'What is the correct way to declare a constant variable in Java?', 'final int x = 5;'),
	('Java', 'Easy', 'for loop', 'while loop', 'do-while loop', 'switch loop', 'Which loop in Java allows the code to be executed at least once?', 'do-while loop'),
	('Java', 'Easy', 'To terminate a loop or switch statement and transfer control to the next statement.', 'To skip the rest of the code in a loop and move to the next iteration.', 'To define a label for a loop or switch statement.', 'To check a condition and execute a block of code repeatedly.', 'What is the purpose of the ''break'' statement in Java?', 'To terminate a loop or switch statement and transfer control to the next statement.'),
	('Java', 'Easy', '+', '-', '*', '/', 'Which Java operator is used to concatenate two strings?', '+'),
	('Java', 'Easy', 'HashMap', 'ArrayList', 'LinkedList', 'HashSet', 'In Java, which collection class provides an implementation of a dynamic array?', 'ArrayList'),
	('Python', 'Easy', 'count()', 'size()', 'length()', 'len()', 'Which Python function is used to calculate the length of a list?', 'len()'),
	('Python', 'Easy', '[1, 2, 3]', '[1, 2, 3, 4]', '[4, 3, 2, 1]', 'Error', 'What is the output of the following Python code snippet? \nx = [1, 2, 3] \nx.append(4) \nprint(x)', '[1, 2, 3, 4]'),
	('Python', 'Easy', 'break', 'continue', 'pass', 'return', 'Which Python statement is used to exit from a loop prematurely?', 'break'),
	('Python', 'Easy', 'To generate a random number within a given range.', 'To iterate over a sequence of numbers.', 'To sort a list in ascending order.', 'To calculate the length of a string.', 'What is the purpose of the ''range()'' function in Python?', 'To iterate over a sequence of numbers.'),
	('Python', 'Easy', 'int', 'float', 'str', 'list', 'In Python, which data type is mutable?', 'list'),
	('Python', 'Easy', 'datetime', 'math', 'os', 'sys', 'Which Python module is used for working with dates and times?', 'datetime')
;

select * from question;

---

Configuring `application.properties`:
To connect Spring Boot with MySQL, update `application.properties`:
spring.application.name=QuizApplication
spring.datasource.url=jdbc:mysql://localhost:3306/questiondb
spring.datasource.username=root
spring.datasource.password=root
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.jpa.hibernate.ddl-auto=update 
spring.jpa.show-sql=true


---

Creating a REST Controller (`QuestionController`)
Create a new class `QuestionController`:
@RestController
@RequestMapping("/question")
public class QuestionController {
    @GetMapping("/all-questions")
    public String getAllQuestions() {
        return "Hi, these are your questions.";
    }
}


---

Running the Application:
1. Run the Spring Boot application from the main class.
2. Check if the server starts on port 8080.
3. Visit `http://localhost:8080/question/all-questions` to verify the response.

---

Next Steps:
- Implement CRUD operations for questions.
- Fetch real questions from the database.
- Introduce business logic for quiz generation.

This concludes the setup phase for the monolithic application. Next, we will focus on developing the full-fledged question management system.

------------------------------------------------------------------------------------
Quiz App Project Setup - Part 2
====================================

At this stage, we have successfully created our project, and now we need to implement key functionalities. 
The primary goal is to retrieve and display all questions from the database when requested.

Implementing Question Retrieval:
Whenever a user requests all questions, the system should return the actual questions stored in the database rather than a placeholder message. 
To achieve this, we need to set up the necessary layers in our Spring Boot application.

---

Understanding the Layered Architecture:
When building a web application, we typically follow a layered architecture, which consists of:
1. Controller Layer - Handles HTTP requests and responses.
2. Service Layer - Contains business logic and processing.
3. Data Access Layer (DAO) - Interacts with the database.

Each layer plays a critical role in managing the application flow and ensuring clean separation of concerns.

# Controller Layer:
- Acts as the entry point for client requests.
- Receives the request and delegates processing to the service layer.
- Example: If a user requests to add two numbers (2 + 3), the controller receives the request but delegates the calculation to the service layer.

# Service Layer:
- Processes data and contains business logic.
- Can perform calculations, apply rules, or fetch data from the DAO layer.
- Example: Instead of performing addition in the controller, the service layer processes the addition request and returns the result.

# DAO Layer:
- Responsible for database interactions.
- Fetches data and maps it to Java objects.

---
Fetching Questions from Database:

1. Setting Up the Controller:
   - Instead of returning hardcoded text, the controller should return actual question data.
   - We create an instance of the `QuestionService` class and use it to fetch questions.

2. Creating the Service Class:
   - A new service class (`QuestionService`) should be created inside the `service` package.
   - Best practice is to separate service, controller, and DAO into different packages.
   - The service class should be annotated with `@Service` to indicate that it is a Spring-managed component.
   - Use `@Autowired` to inject the service into the controller.

3. Creating the Question Model Class:
   - Represents the `Question` table in the database.
   - Fields correspond to database columns (e.g., `id`, `questionTitle`, `option1`, `option2`, `option3`, `option4`, `rightAnswer`, `difficultyLevel`, `category`).
   - The class should be annotated with `@Entity` and `@Table`.
   - Lombok annotations like `@Data` can be used to automatically generate getters, setters, and other utility methods.
   - The primary key (`id`) should be annotated with `@Id` and `@GeneratedValue(strategy = GenerationType.SEQUENCE)`.

4. Creating the DAO Layer:
   - Instead of a class, we create an interface `QuestionDao` inside the `dao` package.
   - This interface extends `JpaRepository<Question, Integer>`.
   - By doing so, we inherit several built-in methods, such as `findAll()` for fetching all records.

---
Implementing Data Fetching:

- The service layer calls the DAO layer to retrieve data from the database.
- Example:
  @Autowired
  private QuestionDao questionDao;
  
  public List<Question> getAllQuestions() {
      return questionDao.findAll();
  }

- The controller then calls the service method to fetch and return the data to the client.
- Example:
  @Autowired
  private QuestionService questionService;
  
  @GetMapping("/questions")
  public List<Question> getAllQuestions() {
      return questionService.getAllQuestions();
  }


---
Running and Testing:
1. Restart the Application
   - After implementing changes, restart the Spring Boot application.

2. Testing the API
   - Open a browser or Postman and hit `http://localhost:8080/questions`.
   - The response should return a JSON array containing all questions stored in the database.

3. Formatting JSON Output
   - If the output appears cluttered, use a browser extension like "JSON Formatter" to improve readability.

4. Adding the Missing Category Field
   - If the category field is missing, update the `Question` model to include `private String category;`.
   - Restart the application and test again to confirm that the category field is included in the response.

---
Summary:
- We structured the application using a three-layered architecture.
- We created a model (`Question`), a DAO (`QuestionDao`), a service (`QuestionService`), and a controller.
- We used Spring Data JPA to simplify database interactions.
- We successfully fetched questions from the database and returned them as a JSON response.

This setup ensures a clean, scalable, and maintainable code structure for our Quiz App.

------------------------------------------------------------------------------------
Quiz App Project Setup - Part 3
===================================  

Adding Services for Fetching questions based on a specific category and Adding Questions: 

In this section, we will add two essential services:  
1. Fetching questions based on a specific category.  
2. Adding new questions to the database.  

# Fetching Questions by Category: 
Currently, our application does not support fetching questions based on a specific category, such as Java or Python. 
We will implement this functionality step by step.  

Creating the Controller Method:  
To achieve this, we need to create a new method in our controller:  

1. Define the method to return a list of questions:  
   public List<Question> getQuestionsByCategory(@PathVariable String category) 
   This method will fetch questions based on the category provided in the URL.  

2. Mapping the Category Parameter from URL:  
   - We use `@GetMapping` because we are fetching data.  
   - The URL will include the category dynamically (e.g., `/questions/Java` or `/questions/Python`).  
   - To capture this dynamic part, we use curly brackets `{category}` in the mapping path:  
    @GetMapping("/questions/{category}")
   - The `{category}` in the URL is mapped to the method parameter using `@PathVariable`.  

3. Calling the Service Layer for Data Retrieval:  
   - The controller delegates the fetching logic to the service layer.  
   - The service layer will query the database using the DAO layer.  

Implementing the Service Layer: 
- The service method fetches questions based on the given category.  
- We need to call a repository method like `findByCategory(category)`.  

Creating the DAO Method:  
- We need a repository method to fetch questions based on category.  
- JPA provides a convention-based method naming approach—simply defining `findByCategory(String category)` is enough.  
- Example:
  List<Question> findByCategory(String category);
- JPA will automatically generate the required SQL query based on the method name.  
- This works because the `category` column exists in the database.  

Testing the Fetch Questions API:  
Once implemented, restarting the application and sending a request (e.g., `/questions/Java`) should return all questions under Java.  
- If a category does not exist (e.g., `/questions/Kotlin`), an empty list is returned.  

---

# Adding Questions to the Database:

Now, we will implement the functionality to add new questions.  

Creating the Controller Method for Adding Questions:  

1. Define the method: 
   @PostMapping("/questions/add")
   public String addQuestion(@RequestBody Question question)
   
   - We use `@PostMapping` because we are sending data to the server.  
   - The `@RequestBody` annotation automatically converts the incoming JSON request into a `Question` object.  

2. Calling the Service Layer to Add Questions:  
   - The controller passes the question object to the service layer.  

Implementing the Service Layer:  

- The service method saves the question in the database using the DAO layer.  
- Example:

  public String addQuestion(Question question) {
      questionDao.save(question);
      return "Success";
  }
  
- Here, `questionDao.save(question);` automatically inserts the new question into the database.  
- The method returns `"Success"` to indicate successful insertion.  

Testing the Add Question API using Postman:  

1. Open Postman.  
2. Set the request method to POST.  
3. Use the endpoint: `/questions/add`.  
4. In the Body section, select raw and set the format to JSON.  
5. Provide a JSON request like:
   {
      "question": "What is Spring Boot?",
      "category": "Java",
      "difficulty": "Easy"
   }
6. Click Send.  
7. If successful, the response will be `"Success"`, and the new question will be added to the database.  

---

# Handling Edge Cases and Status Codes:  

- If an invalid request is sent, a 400 Bad Request error is returned.  
- If the question is successfully added, a 201 Created status should be returned instead of a simple `"Success"` message.  
- In future implementations, proper exception handling and status codes (e.g., `404 Not Found`, `500 Server Error`) should be incorporated.  

This completes the implementation of fetching and adding questions in our quiz application.

------------------------------------------------------------------------------------
Quiz App Project Setup - Part 4
====================================== 

Now, we have a working project where users can:  
- Retrieve all questions.  
- Fetch questions based on a category.  
- Add new questions.  

Enhancing the Question Service : 
Although the question service is functional, we need to improve it by:  
1. Handling Exceptions – Ensuring errors are properly managed.  
2. Using HTTP Status Codes – Returning appropriate status codes with meaningful responses.  

When browsing websites, you've likely encountered error messages like 404 Not Found when a page doesn't exist. 
These status codes help both developers and users understand what went wrong. Instead of just displaying numbers, 
a well-designed system should provide clear messages (e.g., "File Not Found" instead of "404").  

Understanding HTTP Status Codes : 
HTTP status codes fall into five categories:  
- 1xx (100–199): Informational responses.  
- 2xx (200–299): Success responses (e.g., `200 OK`, `201 Created`).  
- 3xx (300–399): Redirection messages.  
- 4xx (400–499): Client-side errors (e.g., `400 Bad Request`, `403 Forbidden`, `404 Not Found`).  
- 5xx (500–599): Server-side errors (e.g., `500 Internal Server Error`).  

For example:  
- 200 OK → Data retrieval is successful.  
- 201 Created → A new resource (e.g., a question) was successfully added.  
- 400 Bad Request → The client made an invalid request.  
- 403 Forbidden → The client lacks permission to access the resource.  
- 405 Method Not Allowed → The client used an incorrect HTTP method (e.g., sending a `POST` request where only `GET` is allowed).  
- 500 Internal Server Error → A problem occurred on the server.  

Implementing ResponseEntity for Proper HTTP Responses : 
To return both data and status codes, we use `ResponseEntity`. Instead of returning only a list of questions, we return a `ResponseEntity<List<Question>>`, which contains:  
1. The actual data (e.g., the list of questions).  
2. The appropriate HTTP status code.  

#Updating QuestionController:
@GetMapping("/questions")
public ResponseEntity<List<Question>> getAllQuestions() {
    return new ResponseEntity<>(questionService.getAllQuestions(), HttpStatus.OK);
}

Now, when a client requests all questions, they receive both the data and `200 OK`.  

#Handling Exceptions in Service Layer :
We wrap our logic in a `try-catch` block to handle errors:

public ResponseEntity<List<Question>> getAllQuestions() {
    try {
        return new ResponseEntity<>(questionRepository.findAll(), HttpStatus.OK);
    } catch (Exception e) {
        e.printStackTrace();
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }
}

If an exception occurs, we return an empty list with 400 Bad Request.  

#Handling Different API Requests:  
1. Fetching Questions by Category
   - Modify the service and controller to return a `ResponseEntity`.  
2. Adding a New Question
   - Use `ResponseEntity<String>` since we are returning a success message. 
   public ResponseEntity<String> addQuestion(Question question) {
       try {
           questionRepository.save(question);
           return new ResponseEntity<>("Success", HttpStatus.CREATED);
       } catch (Exception e) {
           return new ResponseEntity<>("Error", HttpStatus.INTERNAL_SERVER_ERROR);
       }
   }
   - When a question is successfully created, we return 201 Created.  

Testing with Postman: 
1. Fetching Questions → Returns data + `200 OK`.  
2. Adding a Question → Returns `"Success"` + `201 Created`.  
3. Unauthorized Access → Returns `403 Forbidden` if access control is implemented.  

Assignment: 
Implement exception handling for additional cases. Next, we will create a Quiz Service, which will use the Question Service to generate quizzes.  

------------------------------------------------------------------------------------------------------------------
Quiz App Project Setup - Part 5
=======================================

Enhancing the Question Service:
Our question service is now fully functional, supporting CRUD operations:
- Create a question.
- Read questions.
- Update and Delete questions (not yet implemented but can be added later).

So far, we've implemented endpoints to:
- Retrieve all questions.
- Fetch questions by category.

However, the main goal of this project is to build a Quiz Application, which requires a Quiz Service to manage quizzes.

Defining User Roles:
We will define two roles in our system:
1. Admin – Responsible for creating quizzes.
2. User – Can fetch and attempt quizzes.

For example, as a trainer, I might want to create a quiz for my session. I will set up the quiz in advance and launch it during the session for participants to attempt.

Fetching Questions for a Quiz:
We have a database with multiple questions (e.g., Java and Python). The quiz creation process should:
- Select questions based on a specific category (e.g., Java).
- Allow users to specify the difficulty level.
- Randomly select a fixed number of questions (e.g., 5 Java questions).
- Generate the quiz dynamically.

Setting Up the Quiz Controller:
To implement the quiz feature, we first need a new QuizController. This controller will:
- Accept quiz creation requests.
- Fetch quiz questions dynamically.

Defining the API Endpoint:
We need an API to create a quiz with the following parameters:
- Category (e.g., Java, Python)
- Number of Questions (e.g., 5, 10)
- Title (e.g., "JQuiz")

A sample request URL: /quiz/create?category=Java&numQuestions=5&title=JQuiz

This allows users to create a Java quiz with 5 random questions.

Implementing the QuizController:
1. Create a new controller class:
@RestController
@RequestMapping("/quiz")
public class QuizController {
    
    @PostMapping("/create")
    public ResponseEntity<String> createQuiz(
        @RequestParam String category,
        @RequestParam("numQuestions") int numQ,
        @RequestParam String title
    ) {
        
        // Placeholder response
        return new ResponseEntity<>("Quiz creation initiated", HttpStatus.OK);
    }
}


Understanding the Code
- `@RestController` – Defines a REST API controller.
- `@RequestMapping("/quiz")` – Sets the base URL for quiz-related endpoints.
- `@PostMapping("/create")` – Defines an endpoint to create a quiz.
- `@RequestParam` – Extracts parameters from the request URL.
- Response: Returns a success message (`200 OK`).

Testing in Postman
1. Start the Spring Boot application.
2. Send a POST request to: /quiz/create?category=Java&numQuestions=5&title=JQuiz
3. Expected response: Quiz creation initiated


This confirms that the API is working. Next, we will implement the Quiz Service to generate actual quizzes dynamically.

-----------------------------------------------------------------------------------------------------------------------------
Quiz App Project Setup – Part 6
====================================

Creating the Quiz Service:
Since we don’t have a `QuizService` class yet, we need to create one. This class will be placed inside the service package.  

1. We create a `QuizService` class.
2. Since it's a service, it should be annotated with `@Service` in Spring Boot.
3. We will also need an object of this class to handle quiz-related operations.

---

Storing Quizzes in the Database:
When a quiz is created, it must be stored in a database to persist data. Otherwise, the data will be lost upon restarting the application.  

Each quiz consists of questions, which belong to different categories like:
- Java
- Python
- Kotlin  

A single topic can have multiple quizzes (e.g., Java Quiz 1, Java Quiz 2), and some questions might appear in multiple quizzes.  

---

Database Design: Mapping Quiz and Questions:
To store quizzes and questions, we need two tables:
1. Quiz Table
2. Question Table  

Since:
- One quiz has multiple questions (One-to-Many relationship).
- The same question can be part of multiple quizzes (Many-to-Many relationship).  

We must implement a Many-to-Many mapping, which requires an extra table to map quizzes and their corresponding questions.

---

Creating QuizDao:
The service layer requires a DAO (Data Access Object) to interact with the database.  
1. We create an interface `QuizDao` inside the Dao package.
2. It extends `JpaRepository<Quiz, Integer>` (which means it operates on the `Quiz` table with `Integer` as the primary key).
3. Since a quiz consists of multiple questions, we need a `Quiz` entity.

---

Creating the Quiz Model:
We now define the `Quiz` entity inside the model package:  
1. Add attributes:
   - `id` (Primary Key)
   - `title`
   - `questions` (List of questions)  
2. Annotate it with `@Entity` so Hibernate recognizes it as a table.
3. Use Lombok annotations like `@Getter` and `@Setter` to generate getter and setter methods.
4. Since `id` is a primary key, we mark it with `@Id` and auto-generate it using `@GeneratedValue(strategy = GenerationType.IDENTITY)`.
5. To establish the Many-to-Many relationship, we use `@ManyToMany`.

---

Handling Questions in a Quiz:
A quiz consists of multiple questions, and questions are stored separately in the `Question` table.  
To fetch relevant questions for a quiz, we:
1. Create a QuestionDao to manage database interactions for questions.
2. Implement a method to retrieve a specific number of random questions from a given category.

---

Fetching Random Questions from the Database:
Fetching random questions from a specific category requires a custom query.  
Since JPA doesn’t provide an in-built method, we:
1. Use the `@Query` annotation to write a native SQL query.
2. Fetch questions by category and limit the results.
3. Use `ORDER BY RANDOM()` to shuffle the questions.

Example @Query(SELECT * FROM question q WHERE q.category = :category ORDER BY RAND() LIMIT :numQ)

This ensures that:
- Questions belong to the given category.
- They are fetched randomly.
- The number of questions retrieved matches the requested limit.

---

Saving the Quiz:
Once we have:
1. A Quiz title.
2. A list of random questions.
  
We create a `Quiz` object, set the values, and save it in the database using `quizDao.save(quiz)`.  

The method returns a ResponseEntity with:
- A success message `"Success"`.
- HTTP status 201 (Created).

---

Testing with Postman:
After implementing the `createQuiz` functionality:
1. Restart the application.
2. Use Postman to send a request.
3. The response returns 201 Created, confirming the quiz was successfully saved.

Verifying in the Database:
1. Refresh the tables and check if:
   - A new quiz entry appears in the `quiz` table.
   - The `quiz_questions` mapping table correctly links the quiz and its questions.
2. The stored question IDs should match the expected category.

---

Next Steps:
- Implement a feature to fetch a quiz by ID along with its questions.
- Improve error handling and handle exceptions properly.

--------------------------------------------------------------------------------------------------------------------------------------
Quiz App Project Setup - Part 7
===================================

Fetching a Quiz:
Now that we have successfully created a quiz, the next step is to fetch that quiz when a user wants to attempt it. When a quiz is created, the data is stored in our database. To retrieve the quiz, we need to fetch the associated questions from the database using the quiz ID.

Database Structure:
Previously, we had a Question Table. To support quizzes, we created two additional tables:
1. Quiz Table – Stores quiz-related details such as `id` and `title`.
2. Quiz_Questions Table – Maps quizzes to questions, containing `quiz_id` and `question_id`.

Using pgAdmin, we can verify these tables exist in the database. Each quiz is associated with multiple questions, ensuring the relational mapping is intact.

Creating an API to Fetch a Quiz:
To allow users to retrieve a quiz by its ID, we need to create an API endpoint:
- The endpoint should accept a `quizId` as a parameter.
- It should return all questions associated with the specified quiz.

#Creating the Controller Method:
To achieve this, we define a GET request method in the controller. Instead of creating a new quiz, we now focus on fetching an existing one.

#API Endpoint Structure:
- Endpoint: `GET /quiz/get/{id}`
- The `id` parameter represents the quiz ID the user wants to fetch.
- In Postman, we can test this endpoint by providing different quiz IDs.

Initially, when we send the request, we may receive a `404 Not Found` error. This happens because we have not yet implemented the logic to retrieve and return quiz data.

#Implementing the Fetch Logic:
To make this API functional, we need to:
1. Create a method in the controller that calls the quiz service.
2. Fetch the quiz questions from the database using `quizId`.
3. Return the questions to the client.

The method signature in the controller:
@GetMapping("/quiz/get/{id}")
public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable("id") Integer id) {
    return quizService.getQuizQuestions(id);
}

Handling Sensitive Data:
One key concern is data security. The `Question` entity contains:
- Question Title
- Options
- Correct Answer

We must not expose the correct answer to the client, as this would compromise the quiz. Instead, we create a wrapper class to exclude the correct answer.

#Creating a Question Wrapper Class:
To prevent exposing sensitive data, we introduce a new class: `QuestionWrapper`.

public class QuestionWrapper {
    private Integer id;
    private String title;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    
    // Constructor, Getters, and Setters (Using Lombok for brevity)
}

Now, instead of returning a List of Question objects, our API returns a List of QuestionWrapper objects, ensuring that answers remain hidden.

Retrieving Quiz Questions from the Database:
Now, we implement the method in the QuizService to fetch questions based on the quiz ID:

public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
    Optional<Quiz> quiz = quizDao.findById(id);
    if (!quiz.isPresent()) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }
    
    List<Question> questionsFromDB = quiz.get().getQuestions();
    List<QuestionWrapper> questionsForUsers = new ArrayList<>();
    
    for (Question q : questionsFromDB) {
        questionsForUsers.add(new QuestionWrapper(q.getId(), q.getTitle(), q.getOption1(), q.getOption2(), q.getOption3(), q.getOption4()));
    }
    
    return ResponseEntity.ok(questionsForUsers);
}


#Handling Optional Data with `Optional<T>`:
- If the quiz exists, retrieve associated questions.
- If the quiz does not exist, return `404 Not Found`.
- Convert Question objects to QuestionWrapper objects before returning them.

Testing the API in Postman:
1. Restart the server.
2. Send a GET request to `/quiz/get/{id}`.
3. If the quiz exists, we receive a list of questions.
4. The correct answers are not included, ensuring data integrity.

Next Steps: Submitting Quiz Answers:
Once a user completes a quiz, they must submit their answers for evaluation. In the next step, we will:
- Implement an API to submit answers.
- Evaluate responses and calculate scores.
- Return the quiz result to the user.

--------------------------------------------------------------------------------------------------------------------------------------
Quiz App Project Setup - Part 8
=====================================
#Implementing the Quiz Submission and Result Calculation

Now that we have successfully created quizzes and questions and retrieved them, it's time to implement a method that calculates the quiz results. 
When a client submits their responses, the server will process them and return the calculated score.

#Understanding the Client's Request

When a user submits their answers, they send only essential data to the server:
1. Question ID – This uniquely identifies each question.
2. User's Response – The answer selected by the user (not necessarily the correct answer).

For instance, when a user answers a quiz, they submit a request containing:
{
  "quizId": 1,
  "responses": [
    {"id": 18, "response": "3"},
    {"id": 8, "response": "2"},
    {"id": 17, "response": "D"},
    {"id": 6, "response": "A"},
    {"id": 19, "response": "B"}
  ]
}
This request is sent as a POST request in JSON format.

#Fetching Correct Answers from Database

Since we should not rely on memory for correctness, the server fetches correct answers from the database using `MySQL`:
SELECT id, right_answer FROM questions WHERE id IN (18, 8, 17, 6, 19);
This retrieves the correct answers for all given question IDs. If randomization of options is enabled, 
it is better to store and compare the correct answer text rather than just the option (A, B, C, or D).

#Implementing the Submission Endpoint

1. Define the Endpoint in Controller:
@PostMapping("/submit/{id}")
public ResponseEntity<Integer> submitQuiz(@PathVariable Integer id, @RequestBody List<Response> responses) {
    int score = quizService.calculateResult(id, responses);
    return new ResponseEntity<>(score, HttpStatus.OK);
}

This method:
- Accepts quiz ID as a path variable.
- Accepts a list of responses from the user.
- Calls the service method `calculateResult` to compute the score.

2. Creating the Response Class:
@Data
@RequiredArgsConstructor
public class Response {
    private Integer id;
    private String response;
}
- `@Data` (Lombok) generates getter/setter methods.
- `@RequiredArgsConstructor` generates constructors automatically.
- Holds question ID and user's answer.

#Implementing Result Calculation Logic in Service Layer

1. Fetching Quiz Data:
public int calculateResult(Integer quizId, List<Response> responses) {
    Quiz quiz = quizDao.findById(quizId).orElseThrow(() -> new RuntimeException("Quiz not found"));
    List<Question> questions = quiz.getQuestions();
    int correctAnswers = 0;
	
- Fetch the quiz from the database using `quizId`.
- Retrieve the list of questions associated with the quiz.

2. Comparing Responses with Correct Answers:

    for (int i = 0; i < responses.size(); i++) {
        if (responses.get(i).getResponse().equals(questions.get(i).getRightAnswer())) {
            correctAnswers++;
        }
    }
    return correctAnswers;
}

- Iterate through the user responses and compare them with the correct answers from the database.
- Increment the score if the user’s response matches the correct answer.

#Testing the API with Postman

1. Sending all correct responses:
   - Expected output: `5`
2. Changing one answer to an incorrect value:
   - Expected output: `4`
3. Changing two answers to incorrect values:
   - Expected output: `3`

Each test confirms the correctness of our logic.

#Transitioning to Microservices

Currently, the project follows a monolithic architecture, meaning everything (quiz, questions, submission, and results) is in one project. 
However, in a real-world enterprise application, we split functionalities into microservices, such as:
- Quiz Service (manages quizzes)
- Question Service (manages questions)
- Result Service (handles score calculation)

We'll enhance the project and deploy it as a microservices-based system for scalability and efficiency.

Conclusion

In this section, we implemented:
1. A quiz submission API that receives responses.
2. Fetching answers from the database to ensure accuracy.
3. A service-layer calculation to determine the score.
4. Testing with Postman to validate correctness.

Next, we'll enhance this further and migrate it to a microservices architecture!

--------------------------------------------------------------------------------------------------------------------------------------
Hibernate: SELECT * FROM question q Where q.category = ? ORDER BY RAND()
Hibernate: insert into quiz (question_title) values (?)
Hibernate: insert into quiz_questions (quiz_quiz_id,questions_question_id) values (?,?)
Hibernate: insert into quiz_questions (quiz_quiz_id,questions_question_id) values (?,?)
Hibernate: insert into quiz_questions (quiz_quiz_id,questions_question_id) values (?,?)
Hibernate: insert into quiz_questions (quiz_quiz_id,questions_question_id) values (?,?)
Hibernate: insert into quiz_questions (quiz_quiz_id,questions_question_id) values (?,?)


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

-------------------------------------------------------------------------------------------------------------------------------------
Building Microservices: Introduction:
=======================================

Understanding Microservices:
We are now transitioning towards microservices. Previously, we covered the theoretical aspects of microservices, and now we are moving towards practical implementation by building a project.

Quiz Application: Monolithic to Microservices:
Our project is a quiz application, which was initially built as a monolithic application. The reason for starting with a monolithic approach is to help us understand how to transition from a monolithic architecture to a microservices-based architecture. Additionally, this transition helps us grasp why microservices are necessary in certain scenarios.

Currently, our application is a single unit containing multiple functionalities. Although our project is relatively small, consider a large-scale application with numerous services. Managing such an application as a monolith can lead to various challenges.

Existing Monolithic Architecture:
The current quiz application contains two main controllers:
1. Question Controller – Manages adding, removing, updating, and fetching questions.
2. Quiz Controller – Manages quiz creation and selection of questions from various topics (e.g., Java, Python, Blockchain, etc.).

Additionally, suppose we expand the application with more features such as:
- User Service – Manages user accounts.
- Payment Service – Handles payments for quiz participation.
- Certificate Service – Generates certificates after quiz completion.

If all these functionalities exist within a single application, it is considered a monolithic architecture. The downside of this structure is that everything is tightly coupled, making it difficult to scale, manage, and deploy specific services independently.

Breaking the Monolithic Application into Microservices:
The goal is to break the application into smaller, independent microservices. Each microservice should run separately and handle a specific function:
1. Question Service – Manages all question-related operations.
2. Quiz Service – Handles quiz creation and management.
3. User Service – Manages user accounts and authentication.
4. Payment Service – Processes quiz-related payments.
5. Certificate Service – Generates certificates upon quiz completion.

Each of these services should function independently, ensuring they are loosely coupled but can communicate when required.

Converting Monolithic to Microservices: Challenges:
One of the primary challenges in converting to microservices is communication between services. For example, the Quiz Service needs to fetch questions from the Question Service instead of directly accessing a shared database.

Previously, in the monolithic version, when creating a quiz, we directly fetched questions using `questionDao`. However, in a microservices architecture:
- The Quiz Service will not directly access the Question Service's database.
- Instead, it will communicate with the Question Service via a network request (API call).

Each service will now have its own database, ensuring complete separation.

Database Segmentation:
Currently, the application uses a single MySQL database. The Question Service and Quiz Service share this database with separate tables. However, in a microservices setup, each service will have its own database, ensuring complete isolation.

For example:
- Question Service Database: Stores all questions-related data.
- Quiz Service Database: Stores quiz-related data.

Now, when the Quiz Service needs questions, it must request them from the Question Service instead of directly accessing a database.

Scaling Microservices:
One of the key advantages of microservices is independent scaling. In a monolithic system, scaling means replicating the entire application, even if only one part needs scaling. However, with microservices:
- We can independently scale each service based on demand.
- Example: The Quiz Service may need 10 instances while the Question Service requires only 2 instances.
- This flexibility ensures better resource utilization.

Load Balancing in Microservices:
Since multiple instances of a service may exist, we need load balancing to distribute traffic efficiently. For example, if the Quiz Service requires data from the Question Service, it should be able to choose the optimal instance among multiple available ones.

API Gateway: A Central Access Point:
A client does not need to remember individual service URLs. Instead, requests can be routed through an API Gateway, which acts as a single entry point and forwards requests to the appropriate service. The API Gateway provides:
1. Simplified Client Communication – Clients only interact with the gateway instead of multiple services.
2. Security – Authentication and authorization checks can be handled at the gateway.
3. Load Balancing – Distributes requests across multiple instances.
4. Logging & Monitoring – Helps track incoming requests and responses.

Service Registry: Service Discovery Mechanism:
With multiple microservices running independently, how does one service locate another service?
- We use a Service Registry, where all services register themselves.
- Whenever a service needs to communicate with another service, it queries the registry instead of using hardcoded IPs.

Handling Failures with Circuit Breakers:
Microservices must handle failures gracefully. If the Question Service goes down, the Quiz Service should not be stuck waiting indefinitely. Instead, it should:
- Detect failure quickly.
- Provide an alternative response (fallback mechanism).
- Avoid cascading failures by implementing a circuit breaker pattern.

Implementation Plan:
In the upcoming implementation:
1. We will split the monolithic application into two microservices:
   - Question Microservice
   - Quiz Microservice
2. Implement API Gateway to route requests efficiently.
3. Set up Service Registry for service discovery.
4. Implement Load Balancer for handling multiple instances.
5. Introduce Circuit Breaker to handle failures.

Conclusion:
Building microservices is straightforward, but managing their interactions is complex. Through this transition, we aim to achieve scalability, fault tolerance, and better resource management. The next step involves creating our first microservice by separating the Question and Quiz services.

-------------------------------------------------------------------------------------------------------------------------------------
Creating a Question Service (Part 1):
==========================================

In this section, we will begin developing the Question Service as part of a microservices-based Quiz Application. 
This service will be a separate microservice that interacts with other services, such as the Quiz Service.

Setting Up the Project:
To build this microservice, we need to create a new project. Unlike a monolithic application, we will be working with multiple independent projects, 
each representing a microservice. Every microservice will be a separate project in IntelliJ IDEA (or any IDE you use).

#Steps to Create the Question Service Project:
1. Visit [Start.Spring.io](https://start.spring.io/).
2. Select Project Type: Maven.
3. Choose Language: Java.
4. Select Spring Boot Version: A stable version (e.g., 3.1.1).
5. Set Group ID: `com.telusko`.
6. Set Artifact ID: `question-service`.
7. Add Description: Provide a brief project description.

#Required Dependencies:
- Spring Web: Enables web-related functionalities.
- MySQL Driver: Allows database connection.
- Lombok: Reduces boilerplate code by auto-generating getters, setters, and constructors.
- Spring Data JPA: Simplifies database interaction.
- OpenFeign (commented for now): Facilitates inter-service communication.
- Eureka Client (commented for now): Helps with service discovery.

Once the project is set up, download and unzip it, then open it in IntelliJ as a new window. If using Eclipse, import the project instead.

Managing Dependencies:
After opening the project, ensure all required dependencies are installed by checking the Maven dependencies section. 
If unnecessary dependencies like Eureka Server and OpenFeign are present but not needed at this stage, comment them out in the `pom.xml` file. 
After making changes, reload Maven to apply them.

Structuring the Service:
The initial project setup will include a default `QuestionServiceApplication.java` file under the `src/main/java` directory. However, since this is a microservice, it requires proper structuring:

1. Controllers: Handles API requests.
2. DAO (Data Access Objects): Manages database operations.
3. Entities: Defines database models.
4. Services: Implements business logic.

#Removing Unnecessary Components:
Since the `Question Service` is independent, remove unrelated components such as:
- `QuizController.java` (Only `QuestionController.java` is needed)
- `QuizDAO.java` (We will use a separate database for quizzes)
- `QuizService.java`
- Any other quiz-related files

Configuring the Database:
Next, update the `application.properties` file with database configurations for MySQL:

spring.datasource.url=jdbc:mysql://localhost:3306/questiondb
spring.datasource.username=root
spring.datasource.password=root
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.jpa.hibernate.ddl-auto=update 
spring.jpa.show-sql=true

This configuration ensures the service connects to the "questiondb" database. 
If necessary, create the database manually before running the application.

Running the Application:
Once configured, run the service and test it using an endpoint such as:
- GET all questions: `http://localhost:8080/all-questions`

If the setup is correct, it should return all stored questions in JSON format.

Enhancing the Question Service:
To make this service truly independent, implement the following functionalities:

1. Generate Quiz Questions:
   - Previously, the `Quiz Service` generated questions.
   - Now, the `Question Service` will handle this task.
   - `Quiz Service` will request for questions, and `Question Service` will respond with a generated quiz.
   
2. Retrieve Questions for a Specific Quiz:
   - `Quiz Service` stores quiz-related data but not questions.
   - It must fetch questions from `Question Service` using quiz ID.
   
3. Calculate Quiz Score:
   - Earlier, score calculation was handled by `Quiz Service`.
   - Since `Question Service` contains correct answers, it will now calculate the score.

By implementing these changes, the `Question Service` will become fully independent, providing questions and evaluations while ensuring separation from the `Quiz Service`. The next steps involve implementing these functionalities in the code.

-------------------------------------------------------------------------------------------------------------------------------------
Running the Question Service - Part 3:
==========================================

In the previous discussion, we explored the Question Service, covering functionalities like adding and deleting questions. 
However, we had not tested these features yet. This session focuses on testing the service and running multiple instances to simulate real-world microservice scaling.

---

Testing the Question Service:

We have implemented various endpoints in our Question Service, including:
- Get all questions
- Get questions by category
- Get specific questions by ID
- Calculate score based on responses

The objective now is to test these functionalities using Postman and validate the responses.

#Fetching All Questions: The endpoint for retrieving all questions is:

GET http://localhost:8080/question/allQuestions

- This request can be executed via a browser or Postman.
- It returns a JSON response containing all stored questions.
- The HTTP status code should be `200 OK`.

#Fetching Questions by Category: To retrieve questions of a specific category, such as Java, we use:

GET http://localhost:8080/question/category/java

- The response will include all Java-related questions.

#Fetching Specific Questions by ID: If we need questions corresponding to specific IDs, a `POST` request is required:

POST http://localhost:8080/question/getQuestions

- The request body should contain a JSON array of question IDs:
[2, 4, 7, 9, 5]

- The response returns the questions corresponding to these IDs.

---

Testing Score Calculation:
The `get-score` endpoint evaluates quiz responses:

POST http://localhost:8080/question/getTotalScore

- The request body should include responses in JSON format:

[
    {
        "questionId": 1,
        "userSelectedResponse": "Catchable"
    },
    {
        "questionId": 2,
        "userSelectedResponse": "5"
    },
    {
        "questionId": 3,
        "userSelectedResponse": "FALSE"
    }
]

- The response will include the calculated score based on correct answers.

---

Running Multiple Instances of Question Service:
In microservices architecture, scaling a service requires running multiple instances.

#Identifying Port Numbers:
By default, the service runs on port 8080. To run multiple instances:
1. Open run configuration.
2. Add new configuration name as "Question-Service - 8081". Modify the run configuration to use a different port, e.g., `8081`.
3. Add the VM option: -Dserver.port=8081
4. Start both instances.
5. Verify using:
   - `http://localhost:8080/question/all-questions`
   - `http://localhost:8081/question/all-questions`

This confirms that two instances are running independently.

#Handling Multiple Instances in Microservices:
When a Quiz Service communicates with Question Service, it must determine which instance to connect to when multiple are available. 
This introduces the need for service discovery and load balancing, which will be covered in future discussions.

---

Conclusion:
- Successfully tested Question Service endpoints.
- Implemented multiple instances using different port numbers.
- Prepared for service-to-service communication in microservices.

In the next session, we will build the Quiz Service to interact with the Question Service dynamically.

-------------------------------------------------------------------------------------------------------------------------------------
Creating a Quiz Service - Part 4
=====================================
Overview:
Now that we have completed the question service, it's time to build our second microservice: the quiz service. The expectation is that when a client sends a request, they will interact with the quiz service rather than the question service directly. The quiz service, in turn, will communicate with the question service to retrieve data. This establishes an architecture where microservices interact and share data efficiently.
The question service is already functional, though we may make enhancements later. For now, our focus is on developing the quiz service.

Functionality Expected in the Quiz Service:

The quiz service needs to handle three core functionalities:
1. Creating a Quiz: While in a fully expanded system, an admin would create quizzes, we are not implementing authentication at this stage.
2. Fetching Quiz Questions: Participants will retrieve the questions for a specific quiz. For example, a quiz can be created today, and tomorrow users can fetch its questions using a specific quiz ID.
3. Calculating and Retrieving Scores: Participants should be able to view their scores after submitting their answers.

To accomplish this, we will create a new microservice project dedicated to the quiz service.

Setting Up the Quiz Service:

To create the new project:
1. Go to [start.spring.io](https://start.spring.io/).
2. Select:
   - Project: Maven
   - Language: Java
   - Spring Boot Version: 3.1.1 or later
   - Group ID: `com.telusko`
   - Artifact ID: `quiz-service`
   - Packaging: Jar
   - Java Version: 17

Adding Dependencies:

The following dependencies are required:
- Spring Web: To handle REST APIs.
- Spring Data JPA: To interact with the database.
- MySQL Driver: Since we are using MySQL as our database.
- Lombok: To reduce boilerplate code.
- OpenFeign: To enable inter-service communication.
- Eureka Client: To enable service discovery.

After selecting these dependencies, generate the project and download the ZIP file. Once downloaded, unzip it and open the project in IntelliJ IDEA.

Project Initialization:

Upon opening the project:
- Verify Dependencies: Check the `pom.xml` file to ensure all dependencies are included.
- Remove Unnecessary Dependencies: Comment out dependencies that are not required at this stage.
- Reload Maven: Ensure that Maven dependencies are reloaded after making changes to `pom.xml`.

Application Properties Configuration:
Navigate to `application.properties`. Initially, this file will be empty. We will configure it to match our requirements as we proceed.

Reusing Code from Monolithic Application:

Instead of building everything from scratch, we will reuse components from our monolithic application:
1. Copy the necessary controller, service, and repository files from the monolithic project.
2. Modify these files to fit the microservice architecture.
3. Ensure the quiz service does not directly interact with the question database but instead communicates with the question service.

Setting Up the Quiz Database:

Since we are using MySQL:
1. Open Workbench.
2. Expand Servers and locate MySQL.
3. Create a new database named `quizdb`.
4. Tables for this database will be generated automatically based on entity classes in the quiz service.

Structuring the Quiz Service:

- Controllers: Responsible for handling API requests.
- Repositories: Used to interact with the quiz database.
- Services: Contain the business logic for quizzes.
- Models: Represent entities such as quizzes and questions.

Removing Unnecessary Files

Since we copied files from the monolithic application, some are not needed in this microservice:
- Delete `QuestionController`, as it belongs to the question service.
- Remove `QuestionDAO`, since this microservice does not interact with the question database directly.
- Modify the models to use `QuestionWrapper` instead of `Question`, ensuring the quiz service does not store answers.

Handling Inter-Service Communication:
Since the quiz service needs data from the question service, we will implement inter-service communication using Feign Client. This allows the quiz service to fetch questions dynamically from the question service rather than relying on direct database access.

Next Steps:
The next phase involves implementing Feign Client to enable inter-service communication and refining the quiz service’s functionality. This will be covered in the next section.

-------------------------------------------------------------------------------------------------------------------------------------
Need for Service Discovery:
===============================

In our microservices architecture, we are transitioning from a monolithic application to independent services. 
This involves extracting and modifying existing code to fit our new structure.

Refactoring the Quiz Service:
Since we copied code from our previous monolithic application, several modifications are required to ensure the new quiz service works as expected:
- The project name in the controller must be updated to match the new microservice.
- Unnecessary imports, including `QuestionDAO`, should be removed or commented out since the quiz service no longer interacts 
directly with the question database.
- We need to restructure the `createQuiz` method to accept a single DTO (Data Transfer Object) instead of multiple parameters. This will:
  - Improve readability and maintainability.
  - Encapsulate related data fields (`categoryName`, `numberOfQuestions`, `title`) into one object.
  - Reduce parameter complexity in API calls.

Interacting with the Question Service:
Unlike the monolithic system, where the quiz service could directly access the database to fetch questions, 
the microservice approach requires a different strategy:
- The quiz service must communicate with the question service instead of querying a local database.
- Instead of fetching entire question objects, we will retrieve only question IDs to keep our data lightweight and maintain separation of concerns.

Challenges in Microservice Communication:
To fetch questions dynamically, the quiz service needs to call an endpoint to the question service. 
Traditionally, this could be done using a `RestTemplate`, which allows:
- Making HTTP requests between services.
- Defining API endpoints to call specific resources.

However, using a `RestTemplate` introduces several issues:
- Hardcoded URLs and ports: Microservices may run on different machines or dynamically allocated ports, making it unreliable.
- Scaling issues: If multiple instances of a service exist, we need a way to determine which instance to call.
- Lack of flexibility: As services evolve, manually managing API endpoints becomes cumbersome.

Solution: Service Discovery:
To address these issues, we introduced service discovery, which allows microservices to locate each other dynamically 
instead of relying on hardcoded IP addresses.

1. Introduction to Feign Client:
   - Instead of `RestTemplate`, we use Feign Client, a declarative web service client.
   - It simplifies API calls by allowing us to define an interface instead of writing verbose HTTP request logic.
   - Feign resolves service locations dynamically, eliminating the need for hardcoded URLs.

2. Eureka Server for Service Registration & Discovery:
   - To ensure microservices can find each other without hardcoded configurations, we use Eureka, a service discovery tool from Netflix.
   - How it works:
     - Each microservice registers itself with the Eureka Server.
     - Other microservices use the Eureka Client to discover available services by querying the Eureka Server.
   - This eliminates the need for specifying IP addresses and ports manually.

Benefits of Service Discovery:
- Dynamic Scaling: Services can run on different instances without requiring code changes.
- Fault Tolerance: If one instance of a service fails, Eureka helps in load balancing by redirecting requests to another instance.
- Simplified Configuration: No need to manually manage service locations.
- Better Maintainability: Changes to one service do not require updates in multiple places.

Next Steps:
To fully enable service discovery and inter-service communication, we need to:
1. Set up an Eureka Server to act as a registry.
2. Register both the Quiz Service and Question Service with Eureka.
3. Modify the Quiz Service to use Feign Client for API calls instead of `RestTemplate`.

This structured approach ensures that our microservices interact efficiently without tight coupling, making the system scalable and maintainable.
-------------------------------------------------------------------------------------------------------------------------------------
Creating a Service Registry
================================

#Understanding the Need for a Eureka Server:
In a microservices architecture, different services need to communicate with each other. 
When multiple microservices exist, how does one service find another dynamically without hardcoding IP addresses or URLs? 
This is where a service registry comes into play.

A Eureka Server is a service discovery server that enables microservices to register themselves and discover other services dynamically. 
Instead of manually configuring service locations, microservices can simply register with Eureka, 
and any service looking for another can query Eureka to get the necessary details.

For example, in our system, we have two microservices:
- Quiz Service (which needs to create quizzes)
- Question Service (which provides questions for the quizzes)

Since these services are independent, the Quiz Service must locate the Question Service dynamically. 
This is achieved by setting up a Eureka Server where the Question Service registers itself, and the Quiz Service can discover it without 
knowing its exact location.

#Setting Up the Eureka Server:
Step 1: Creating a Spring Boot Project:
1. Navigate to [start.spring.io](https://start.spring.io/) to create a new Spring Boot project.
2. Select Maven as the build tool and choose Java as the programming language (Gradle is also an option if preferred).
3. Configure the project metadata:
   - Group ID: `com.example` (or any other preferred value)
   - Artifact ID: `service-registry`
   - Packaging: `Jar`
   - Java Version: `17`

Step 2: Adding Dependencies:
The project requires only two dependencies:
1. Spring Web (to enable web functionalities)
2. Spring Cloud Eureka Server (for service discovery)

Once selected, generate and download the project, unzip it, and open it in IntelliJ IDEA or any preferred IDE.

#Configuring the Eureka Server:
After setting up the project, follow these steps to configure the Eureka server:

Step 1: Enable Eureka Server:
In the `ServiceRegistryApplication.java` file (the main application file), add the `@EnableEurekaServer` annotation to enable Eureka:

@SpringBootApplication
@EnableEurekaServer
public class ServiceRegistryApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceRegistryApplication.class, args);
    }
}

Step 2: Configure `application.properties`:
Modify the `src/main/resources/application.properties` file to set up the Eureka server:

spring.application.name=service-registry
server.port=8761

# Disable Eureka server from registering itself
eureka.client.register-with-eureka=false
eureka.client.fetch-registry=false
eureka.instance.hostname=localhost

- `spring.application.name`: Sets the name of the Eureka server.
- `server.port=8761`: By default, Eureka runs on port 8761.
- `eureka.client.register-with-eureka=false`: Prevents the Eureka server from registering itself.
- `eureka.client.fetch-registry=false`: Ensures the server does not fetch service instances (only clients should do this).
- `eureka.instance.hostname=localhost`: Defines the hostname for the Eureka server.

Step 3: Running the Eureka Server:
Start the Spring Boot application. Once running, open a browser and visit:
http://localhost:8761

You should see the Eureka dashboard, but at this point, no services are registered.

#Registering a Microservice with Eureka:
To allow microservices like the Question Service to register with Eureka, follow these steps:

Step 1: Adding Eureka Client Dependency:
In the `pom.xml` of the Question Service, add the Eureka Client dependency:

<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
</dependency>

Step 2: Enable Eureka Client:
Modify the main application file of the Question Service:

@SpringBootApplication
@EnableEurekaClient
public class QuestionServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(QuestionServiceApplication.class, args);
    }
}

Step 3: Configuring `application.properties`:
In `src/main/resources/application.properties`, add the following configurations:

spring.application.name=question-service
server.port=8080

# Eureka Client Configuration
eureka.client.service-url.defaultZone=http://localhost:8761/eureka/

Step 4: Running the Question Service:
Start the Question Service application. Once running, visit the Eureka dashboard (`http://localhost:8761`). 
You should see the Question Service registered.

Step 5: Running Multiple Instances:
To demonstrate load balancing, run multiple instances of the Question Service by specifying different ports:
server.port=8081

Restart the service, and now two instances of the Question Service should be visible in Eureka.

#Connecting the Quiz Service to Eureka:
The Quiz Service must find the Question Service dynamically using Eureka.

Step 1: Add the Eureka Client Dependency:
Add the same Eureka Client dependency to the `pom.xml` of the Quiz Service.

Step 2: Configure `application.properties`:
spring.application.name=quiz-service
server.port=8082

eureka.client.service-url.defaultZone=http://localhost:8761/eureka/

Step 3: Using Feign Client for Communication:
Instead of using `RestTemplate`, we use Feign Client, a declarative way to make HTTP requests.

Add the dependency:
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-openfeign</artifactId>
</dependency>

Enable Feign in the main application:

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class QuizServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(QuizServiceApplication.class, args);
    }
}

Define a Feign Client interface for the Question Service:

@FeignClient("QUESTION-SERVICE")
public interface QuizInterface {
	
    @GetMapping("/question/generateQuestions")
    public ResponseEntity<List<Integer>> getQuestionsForQuiz
            (@RequestParam String categoryName, @RequestParam Integer numberOfQuestions );

    @PostMapping("/question/getQuestions")
    public ResponseEntity<List<QuestionWrapper>> getQuestionsFromId(@RequestBody List<Integer> questionIds);

    @PostMapping("/question/getTotalScore")
    public ResponseEntity<Integer> getScore(@RequestBody List<UserResponse> userResponses);

}

Now, the Quiz Service can discover and communicate with the Question Service dynamically, without needing hardcoded URLs.

#Conclusion
By implementing a Eureka Server, we enable dynamic service discovery for microservices.
- The Eureka Server registers microservices dynamically.
- The Question Service registers itself and can scale with multiple instances.
- The Quiz Service discovers and communicates with the Question Service using Feign Client.

This setup ensures that microservices remain scalable, fault-tolerant, and dynamically discoverable, improving flexibility and maintainability 
in a distributed system.
-------------------------------------------------------------------------------------------------------------------------------------------
Working with Feign
=========================

Setting Up the Eureka Server:
To establish communication between microservices, we need to start by running the Eureka Server. 
Once it's running, we can register our services with it. In this case, we have Question-Service running with two instances:
- One instance on port `8081`
- Another instance on the default port

We've ensured that the service name for Question-Service is correctly set. Now, we move to our Quiz-Service to enable inter-service communication.

Enabling Eureka Client in Quiz-Service:
Currently, Quiz-Service is not yet registered as a Eureka client. 
This means that while Quiz-Service can find Question-Service, the reverse is not true. 
To fix this, we must enable the Eureka client in Quiz-Service.

Communicating with Question-Service:
To fetch questions from Question-Service, we need to send HTTP requests. 
The traditional approach is using `RestTemplate`, where we manually specify IP addresses, port numbers, and other configurations. 
However, a more efficient approach is to use Feign Client.

Introducing Feign Client:
Feign Client simplifies inter-service communication by abstracting away the need for direct REST calls. 
Instead of handling IP addresses and configurations manually, Feign allows us to declare the service name, 
and it handles the connection automatically.

Implementing Feign Client in Quiz-Service:
1. Create an Interface for Feign Communication:
   - Define an interface (e.g., `QuizInterface`) to communicate with Question-Service.
   - Place this interface inside a new package, e.g., `feign`.

2. Declare Required Methods:
   - Generate questions - getQuestionsForQuiz()
   - Fetch questions by ID - getQuestionsFromId()
   - Get quiz score - getScore()

3. Annotate the Interface with `@FeignClient`:

   @FeignClient(name = "QUESTION-SERVICE")
   public interface QuizInterface {
	   @GetMapping("/question/generateQuestions")
       public ResponseEntity<List<Integer>> getQuestionsForQuiz
            (@RequestParam String categoryName, @RequestParam Integer numberOfQuestions );
   }
  
   - Ensure that the service name matches the one registered in Eureka (`QUESTION-SERVICE`).
   - Methods should mirror the endpoints in Question-Service.

Adding Feign Dependency:
Before using Feign, we must include the necessary dependency in `pom.xml`:
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-openfeign</artifactId>
</dependency>

After adding this, refresh the dependencies to ensure they are properly loaded.

Enabling Feign Client in Quiz-Service:
To enable Feign clients in the application, add the `@EnableFeignClients` annotation in the main class of `Quiz-Service`:

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class QuizServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(QuizServiceApplication.class, args);
    }
}

Using Feign Client in Quiz Service:
1. Inject `QuizInterface` using `@Autowired`:
   @Autowired
   private QuizInterface quizInterface;
   
2. Call Feign Methods Instead of `RestTemplate`:
   List<Integer> questions = quizInterface.getQuestionsForQuiz(category, numberOfQuestions);
   
3. Process the Response:
   Quiz quiz = new Quiz();
   quiz.setTitle(title);
   quiz.setQuestionIds(questions);
   quizRepository.save(quiz);

Configuring Application Properties:
Update `application.properties` to properly register Quiz-Service in Eureka:
spring.application.name=QUIZ-SERVICE
server.port=8090

This ensures that the service runs on port `8090` and registers itself in Eureka.

Running and Testing the Application:
1. Start Eureka Server.
2. Run `Question-Service` (with two instances).
3. Run `Quiz-Service`.
4. Verify Registration in Eureka Dashboard (`http://localhost:8761/`).
5. Call `http://localhost:8090/quiz/createQuiz` API to test Feign integration.

After running these steps, Quiz-Service can successfully fetch questions from Question-Service using Feign Client. 
This setup enhances maintainability and simplifies microservice communication.

-------------------------------------------------------------------------------------------------------------------------------------------
Microservice is Calling a Microservice:
==========================================  

Now it's time to run the project and test its functionality. We will create a quiz and verify if communication between the Quiz Service and Question Service is happening correctly.

Testing via Postman :  
To test the microservices, we will use Postman. First, ensure the Quiz Service is running on port 8090. The API endpoint for creating a quiz is:  
POST http://localhost:8090/quiz/createQuiz


#Sending Data :
A quiz requires three inputs:  
1. Category Name – e.g., `"Java"`  
2. Number of Questions – e.g., `5`  
3. Title – e.g., `"Springer's Quiz 1"`  

We send this data as a JSON payload :
{
  "categoryName": "Java",
  "numQuestions": 5,
  "title": "Springer's Quiz 1"
}

After sending the request, we encountered a 500 Internal Server Error.

Debugging the Issue :  
Checking the logs, the error originated from the Feign Client in the Quiz Service. It failed to locate the correct Question Service endpoint. 
The issue? We were calling:  /question-service/generateQuestions

instead of /question-service/question/generateQuestions

Since all question-related endpoints should be under `/question`, we corrected the Feign Client mappings:
/question-service/question/generateQuestions
/question-service/question/getQuestions
/question-service/question/getTotalScore

After making these changes, we restarted the Quiz Service.

Verifying the Fix : 
Re-running the Postman request now returns "Success". But is the data correctly stored? To verify:  
1. Open Workbench and check the Quiz Table.  
2. Confirm that the Springer’s Quiz 1 entry exists.  
3. Ensure that the questions are retrieved from the Question Service, as the Quiz Service itself does not store question data.  

This confirms that Quiz Service successfully interacts with Question Service to generate quizzes dynamically.

Eureka Server & Service Discovery : 
To monitor microservices, we check the Eureka Server. 
While services appear listed, there is no health status because Spring Boot Actuator is missing. 
This can be added later for better observability.

Next Steps : 
A pending question remains:  
- Which instance of Question Service is getting called when multiple instances exist?  
We will analyze this behavior in the next section.

-------------------------------------------------------------------------------------------------------------------------------------------
Completing the Two Microservices
=====================================
Before implementing load balancing, we need to complete some functionalities in the Quiz Service. 
Specifically, we need to finalize three key methods in the QuizController:
1. Create Quiz – /quiz/createQuiz - This has already been implemented and tested.
2. Get Quiz Questions – /quiz/getQuizQuestions/{quizId} - Retrieves all questions associated with a given quiz ID.
3. Submit Quiz & Get Score - /quiz/submitQuiz/{quizId} – Evaluates responses and calculates the score.

Implementing "Get Quiz Questions":
For each quiz, a unique ID is generated. Multiple quizzes can be created for the same topic, each with a different ID. 
The challenge is that the Quiz Service does not store questions directly—it only keeps question IDs. 
To retrieve actual questions, the Quiz Service must communicate with the Question Service.

#Steps to Implement:
1. Retrieve the quiz details using the given quiz ID.
2. Extract the list of question IDs from the quiz.
3. Call the Question Service to fetch the actual questions corresponding to those IDs.
4. Return the retrieved questions as a response.

#Implementation:
- The `getQuizQuestions()` method in QuizController first fetches the quiz entity.
- It extracts the list of question IDs.
- It then calls the Question Service via Feign Client (or RestTemplate) to retrieve the actual questions.
- The response consists of a list of question wrappers (without answers).

#Testing in Postman:
1. Send a GET request to `/quiz/getQuizQuestions/{quizId}`.
2. Verify that the response contains the expected list of questions.
3. Cross-check with the database to confirm correct retrieval.

Implementing "Submit Quiz & Get Score":
When a user submits answers, the system should compute the score. 
However, the Quiz Service does not calculate scores—this task is handled by the Question Service.

#Steps to Implement:
1. The user submits their responses.
2. The Quiz Service forwards the responses to the Question Service.
3. The Question Service evaluates the answers and returns a score.
4. The Quiz Service then displays this score to the user.

#Implementation:
- The `submitQuiz()` method in QuizController receives a list of responses.
- It calls the `getScore()` method in the Question Service.
- The Question Service calculates the score and returns an integer.
- The final response is sent back to the user.

#Testing in Postman:
1. Send a POST request to `/quiz/submitQuiz/{quizId}` with user responses.
2. Verify that the response contains the expected score.
3. Modify a response to an incorrect answer and observe the score change.

Finalizing the Microservices:
At this point, both microservices are working correctly:
- Quiz Service successfully retrieves questions from Question Service.
- Quiz Service delegates score calculation to Question Service.
- The system is correctly handling quiz creation, retrieval, and submission.

Next Challenge: Load Balancing:
Currently, we have two instances of the Question Service running on different ports (8080 and 8081). 
However, we do not know which instance is responding to a given request. To manage this, we need to implement Load Balancing, 
which will be discussed next.

----------------------------------------------------------------------------------------------------------------------------------
Load Balancing
===================
Load balancing is a crucial concept in distributed systems and microservices architecture. 
It ensures that incoming requests are distributed evenly across multiple instances of a service to prevent overloading a single instance.

#Horizontal Scaling and Load Balancing:
=========================================
When we have multiple instances of an application running, we implement horizontal scaling. 
This allows a system to handle increased traffic by adding more instances rather than upgrading a single instance. 
Load balancing ensures that client requests are routed to the least busy or available instance.

For example, if we have three instances of a service, and two instances (Instance 1 and Instance 3) are busy, 
then any new request is directed to Instance 2, which is free. 
This prevents a single instance from handling all requests, ensuring efficient resource utilization.

#Load Balancing in Microservices:
Each microservice can be treated as an independent application. 
Some services may require multiple instances, depending on the traffic load. 
For example, in an application with a Quiz Service and a Question Service, the Question Service might receive more requests. 
To handle the load efficiently, we deploy multiple instances of the Question Service.

Now, when the Quiz Service needs to interact with the Question Service, it must determine which instance to communicate with. 
Load balancing directs the request to the least busy instance, optimizing performance.

#Manual vs. Automatic Load Balancing:
Earlier, load balancing was managed manually, but modern tools and frameworks provide built-in support. 
Spring Boot, with Eureka Client and Spring Cloud Load Balancer, simplifies this process. 
The required libraries are included by default, eliminating the need for manual configuration.

#Implementation with Spring Cloud Load Balancer:
Spring Boot automatically handles client-side load balancing when using Feign Client. 
Feign Client detects available instances and routes requests to the least busy one.

To verify this behavior, consider the Question Service running on two ports: 8080 and 8081. 
We can print the port number being used for each request to observe load balancing in action.

Steps to Test Load Balancing:
1. Inject the Environment object in the controller:
   @Autowired
   private Environment environment;
   
2. Print the port number inside the `getQuestionsFromId()` method:
   System.out.println("Handling request on port: " + environment.getProperty("local.server.port"));
   
3. Restart both instances of the Question Service and test the API - /getQuizQuestions/{quizId} using Postman.
4. Send multiple GET requests to the Quiz Service and check the logs.
5. The requests will be distributed across both instances (8080 and 8081), ensuring balanced traffic.

#Observing Load Balancing Behavior:
- Initially, the same instance might handle multiple requests.
- After repeated requests, the load balancer redirects traffic to the other instance.
- Over time, requests are distributed dynamically based on instance availability.

#Key Takeaways:
- Load Balancing distributes requests among multiple instances to avoid overloading.
- Spring Cloud Load Balancer provides built-in support without manual configuration.
- Feign Client automatically detects available instances and routes requests efficiently.
- Eureka Client helps in service discovery, ensuring requests are dynamically balanced.
- Printing the port number confirms that requests are directed to different instances dynamically.

By leveraging Spring Cloud Load Balancer and Eureka Client, we achieve automatic and efficient load balancing without additional setup, 
making our microservices architecture more scalable and resilient.
--------------------------------------------------------------------------------------------------------------------------------
API Gateway in Microservices
==================================
In this project, we have implemented multiple microservices and explored various concepts such as service discovery and 
communication between services. We utilized Eureka Server and Eureka Client to enable microservices to locate and communicate 
with each other dynamically.

Need for an API Gateway:

A user interacting with a microservices-based application sees it as a single entity, even though it consists of multiple microservices. 
However, each microservice runs on a different port and requires specifying these port numbers when making requests. For example:
- Quiz Service runs on port 8090
- Question Service runs on ports 8080/8081
- Eureka Server runs on port 8761

Apart from handling multiple ports, other challenges arise:
- Authentication: Users should not have to log in separately for each microservice.
- Logging and Monitoring: A centralized mechanism is required to track requests.
- Cross-cutting Concerns: Features like authentication, rate limiting, and logging should be managed in one place.

To address these, we introduce an API Gateway, which acts as a unified entry point for all client requests. Instead of interacting with multiple services separately, users send requests to the API Gateway, which then forwards them to the appropriate microservice.

Setting Up API Gateway in Spring Cloud:

To implement an API Gateway in Spring Cloud:
1. Create a new Spring Boot project using [start.spring.io](https://start.spring.io/)
2. Select dependencies:
   - `Spring Cloud Gateway` (for API Gateway functionality)
   - `Eureka Discovery Client` (to register the gateway with Eureka Server)
3. Configure the project:
   - Assign a name: `api-gateway`
   - Use Java 17 (or the version installed on your system)
   - Set up a port (e.g., 8765)

API Gateway Configuration:

After setting up the project, update `application.properties` to register the gateway with Eureka:

spring.application.name=api-gateway
server.port=8765
spring.cloud.gateway.discovery.locator.enabled=true
spring.cloud.gateway.discovery.locator.lower-case-service-id=true

- `spring.cloud.gateway.discovery.locator.enabled=true`: Enables the API Gateway to discover services dynamically via Eureka.
- `spring.cloud.gateway.discovery.locator.lower-case-service-id=true`: Allows using lowercase service names in API paths like "quiz service" - http://localhost:8765/quiz-service/quiz/getQuizQuestions/1

Running the API Gateway:
After adding the configurations, run the API Gateway application. It will register with Eureka Server and appear as a service.

#Testing with Postman:

To test the API Gateway:
- Instead of accessing services directly via their ports (e.g., `http://localhost:8090/quiz/getQuizQuestions/1`),
- Use the API Gateway (`http://localhost:8765/quiz-service/quiz/getQuizQuestions/1`)

The API Gateway will:
1. Receive the request
2. Identify the correct microservice using Eureka
3. Forward the request to the appropriate service

If the API Gateway does not recognize service names, ensure that the discovery locator is enabled in `application.properties`.

Benefits of Using API Gateway:
- Single Entry Point: Users interact with a single URL instead of multiple microservice endpoints.
- Load Balancing: API Gateway distributes requests across multiple instances of a microservice.
- Security: Centralized authentication and authorization can be applied.
- Logging & Monitoring: Unified tracking of requests for debugging and analytics.
- Simplified Client Interaction: The client does not need to know individual service locations or ports.

Summary:

Our microservices architecture consists of:
1. Quiz Service: Manages quizzes.
2. Question Service: Stores and retrieves questions.
3. Eureka Server: Manages service discovery.
4. API Gateway: Routes and secures requests.

When a user wants to take a quiz:
- They send a request to API Gateway.
- API Gateway routes it to the Quiz Service.
- Quiz Service fetches questions from the Question Service.
- API Gateway ensures secure and seamless communication.

This structured approach simplifies microservices communication and enhances system security and maintainability.

--------------------------------------------------------------------------------------------------------------------------------
