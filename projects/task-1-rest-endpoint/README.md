# Task 1: Set Up a REST Endpoint

## Objective
Create a REST API endpoint that returns a list of users in JSON format.

---

## Concepts Learned

### 1. `@RestController`
- The `@RestController` annotation is used to define a controller that handles RESTful web requests.
- It combines `@Controller` and `@ResponseBody`, so you don’t need to annotate each method with `@ResponseBody`.

---

### 2. `@GetMapping`
- This annotation is used to map HTTP GET requests to specific handler methods in the controller.
- Example: `@GetMapping("/users")` maps requests to the `/users` endpoint.

---

### 3. Returning a `List` in Spring Boot
- Spring Boot can automatically serialize a `List` of objects into JSON format.
- Define a POJO (Plain Old Java Object) with fields (e.g., `id`, `name`), and return a `List<POJO>`.

---

### 4. JSON Serialization
- Spring Boot uses Jackson for JSON serialization by default.
- Returning a Java object or collection from a controller method automatically converts it to JSON.

---

## Implementation Steps
1. Define a `User` class:
   - Add fields like `id` and `name`.
   - Include getters, setters, and constructors.

2. Create a `UserController` class:
   - Annotate it with `@RestController`.
   - Define a method with `@GetMapping("/users")` to return a list of `User` objects.

3. Run the application and access the `/users` endpoint to see the JSON response.

---

## Example Usage
- Start the application.
- Send a GET request to `http://localhost:8080/users` (using a browser or tools like Postman).
- You should see a JSON array with user data.
