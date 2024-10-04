# QuizApp

## Overview
QuizApp is a simple console-based quiz application designed to demonstrate basic Java programming concepts. The application allows users to take quizzes, track scores, and validate answers. It follows a layered architecture to ensure scalability, maintainability, and separation of concerns.

## Project Architecture

The project is structured into different layers, following best practices for modular development:

1. **Presentation Layer (UI/CLI)**:
   - Interacts with the user.
   - Handles user input and displays output.
   
2. **Service Layer (Business Logic)**:
   - Processes the quiz logic, such as tracking scores, validating answers, and managing quiz flow.
   
3. **Data Access Layer (Persistence)**:
   - Manages the data (questions, answers, scores). This can later evolve to read from files, databases, or APIs.

4. **Model Layer (Entities)**:
   - Defines the core entities like `Question`, `Quiz`, and `User`.

## Directory Structure

```
QuizApp/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── com/
│   │   │   │   ├── precious/
│   │   │   │   │   ├── quizapp/
│   │   │   │   │   │   ├── QuizApp.java         # Main entry point for the application
│   │   │   │   │   │   ├── controller/
│   │   │   │   │   │   │   ├── QuizController.java  # Handles the flow of the quiz
│   │   │   │   │   │   ├── service/
│   │   │   │   │   │   │   ├── QuizService.java     # Handles quiz-related logic
│   │   │   │   │   │   │   ├── QuestionService.java # Handles question-related logic
│   │   │   │   │   │   ├── repository/
│   │   │   │   │   │   │   ├── QuestionRepository.java # Access to question data
│   │   │   │   │   │   ├── model/
│   │   │   │   │   │   │   ├── Question.java     # Question model class
│   │   │   │   │   │   │   ├── User.java         # User model class (optional)
│   │   │   │   │   │   ├── utils/
│   │   │   │   │   │   │   ├── Validator.java    # Utility class for validation functions
│   ├── resources/                                # Store static files or configs
│   └── test/                                     # Unit tests
│
├── README.md                                     # Project overview and instructions
├── build.gradle / pom.xml                        # Project dependencies (Gradle or Maven)
└── .gitignore                                    # Git ignore rules
```

## Class Descriptions

### `QuizApp.java`
- The entry point of the application that initializes the quiz and provides a command-line interface for users.

### `QuizController.java`
- Handles the interaction between the user and the application logic. Manages the flow of the quiz, user input, and output.

### `QuizService.java`
- Contains the core logic of the quiz, such as fetching questions, checking answers, and calculating the score.

### `QuestionRepository.java`
- Handles the data access layer for quiz questions. Initially, the questions will be hardcoded, but this can evolve to fetch data from external sources.

### `Question.java`
- A model class that defines the structure of a quiz question, including fields for the question text, options, and the correct answer.

## Features

- Add a layer of abstraction for better code organization and scalability.
- Use the repository pattern to manage data (questions, answers, scores).
- Modular design to enable easy extension and maintenance.
- Input validation to prevent invalid entries.

## Getting Started

### Prerequisites

- Java Development Kit (JDK) 8 or above.
- A terminal or IDE to run the application.
- A GUI-enabled platform

### How to Run the Application

1. Clone the repository:
   ```
   git clone https://github.com/precious-quizapp.git
   ```
2. Navigate to the project directory and compile:
   ```
   javac com/precious/quizapp/QuizApp.java
   ```
3. Run the app:
   ```
   java com.precious.quizapp.QuizApp
   ```

---

## Future Improvements

- Add support for storing user scores in a database.
- Improve question repository to fetch questions from external files or APIs.
- Implement a graphical user interface (GUI) for better user experience.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
