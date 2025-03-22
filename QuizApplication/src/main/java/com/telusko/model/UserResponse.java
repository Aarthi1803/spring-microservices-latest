package com.telusko.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class UserResponse {
	
    private Integer questionId;
    private String userSelectedResponse;
    
}

/*
	@RequiredArgsConstructor` in Lombok:
	`@RequiredArgsConstructor` is an annotation provided by Lombok that automatically generates a constructor with required 
	(final or `@NonNull` annotated) fields. This helps in reducing boilerplate code for constructor creation in Java classes.
	
	---
	
	How `@RequiredArgsConstructor` Works:
	- It only generates a constructor for final fields or fields annotated with `@NonNull`.  
	- Other fields (non-final and without `@NonNull`) will not be included in the generated constructor.
	
	---
	
	Example Usage:
	#Without Lombok (Manual Constructor):
	public class UserService {
	    private final UserRepository userRepository;
	    
	    public UserService(UserRepository userRepository) {  // Manually written constructor
	        this.userRepository = userRepository;
	    }
	}
	
	
	#With Lombok (`@RequiredArgsConstructor`):
	import lombok.RequiredArgsConstructor;
	import org.springframework.stereotype.Service;
	
	@Service
	@RequiredArgsConstructor
	public class UserService {
	    private final UserRepository userRepository; // Lombok generates constructor automatically
	}
	
	No need to write a constructor manually—Lombok will generate:
	public UserService(UserRepository userRepository) {
	    this.userRepository = userRepository;
	}
	
	
	---
	
	Including `@NonNull` Fields:
	If a field is not final, but you still want it in the constructor, use `@NonNull`:
	
	import lombok.NonNull;
	import lombok.RequiredArgsConstructor;
	
	@RequiredArgsConstructor
	public class EmployeeService {
	    private final EmployeeRepository employeeRepository;  // Included in constructor
	    @NonNull private String serviceType;                 // Also included in constructor
	    private int employeeCount;                           // NOT included (not final or @NonNull)
	}
	
	Lombok generates:
	public EmployeeService(EmployeeRepository employeeRepository, String serviceType) {
	    this.employeeRepository = employeeRepository;
	    this.serviceType = serviceType;
	}
	
	`employeeCount` is ignored because it is neither `final` nor `@NonNull`.
	
	---
	
	Use Case in Spring Boot:
	`@RequiredArgsConstructor` is very useful in Spring Boot services because:
	1. It eliminates the need for `@Autowired` (Spring automatically injects dependencies).
	2. It makes classes immutable (since dependencies are `final`).
	3. It reduces boilerplate code.
	
	#Example: Service Layer in Spring Boot:
	import lombok.RequiredArgsConstructor;
	import org.springframework.stereotype.Service;
	
	@Service
	@RequiredArgsConstructor
	public class ProductService {
	    private final ProductRepository productRepository; // Automatically injected
	}
	
	Spring will automatically inject `ProductRepository` without needing `@Autowired`.
	
	---
	
	When to Use `@RequiredArgsConstructor`:
	✅ When you have final fields (dependencies) that should be injected via the constructor.  
	✅ When using Spring Boot services, controllers, or repositories.  
	✅ When you want to make your class immutable and avoid setter methods.  
	✅ When you want cleaner, more readable code without manually writing constructors.  
	
	---
	
	Difference Between `@RequiredArgsConstructor`, `@AllArgsConstructor`, and `@NoArgsConstructor`:
	Annotation - What It Does
	`@RequiredArgsConstructor` - Generates a constructor with only final and `@NonNull` fields 
	`@AllArgsConstructor` - Generates a constructor with all fields 
	`@NoArgsConstructor` - Generates a constructor with no arguments 
	
	---
	
	Final Thoughts:
	- `@RequiredArgsConstructor` is best for dependency injection in Spring Boot.  
	- It helps to keep classes immutable and prevents unnecessary modifications.  
	- Use it in services, repositories, and controllers where constructor-based dependency injection is needed.  
	

*/