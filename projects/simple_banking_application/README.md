```markdown
# Simple Banking Application

## Project Description
The **Simple Banking Application** is a basic console-based Java project that simulates a simple banking system. Users can perform common banking operations such as:
- Depositing money
- Withdrawing money (with a check for sufficient balance)
- Viewing their current account balance

This project is designed to practice fundamental Java concepts such as variables, data types, conditionals, loops, and relational operators.

## Features
- **Deposit Money**: Users can add money to their account.
- **Withdraw Money**: Users can withdraw money, with a check to ensure the balance is sufficient.
- **View Balance**: Displays the current account balance.
- **Continuous Transactions**: The user can perform multiple transactions without restarting the program.

## Concepts Used
- **Variables**: Store account balance, transaction amounts, etc.
- **Data Types**: Handle monetary values, user inputs, etc.
- **Relational Operators**: Check for conditions like sufficient balance before withdrawal.
- **If-Else Statements**: Control flow based on user actions and balance checks.
- **Loops (While/Do-While)**: Allow users to perform multiple transactions within a single session.
  
## How to Run the Project
1. **Clone the Repository**  
   Clone this repository to your local machine using the command:
   ```bash
   git clone https://github.com/yourusername/banking-application.git
   ```

2. **Compile the Code**  
   Navigate to the project directory and compile the Java code using:
   ```bash
   javac BankingApplication.java
   ```

3. **Run the Program**  
   Run the compiled Java program using:
   ```bash
   java BankingApplication
   ```

## Usage Instructions
1. On running the program, the user will be prompted to choose an action (deposit, withdraw, view balance, or exit).
2. The user will input the amount to deposit or withdraw as necessary.
3. The program will continuously loop, allowing the user to perform multiple transactions until they choose to exit.

## Example Output
```bash
Welcome to the Simple Banking Application!
Please select an option:
1. Deposit Money
2. Withdraw Money
3. View Balance
4. Exit

Enter your choice: 1
Enter the amount to deposit: 500
Deposit successful! Your new balance is: $500.00

Please select an option:
1. Deposit Money
2. Withdraw Money
3. View Balance
4. Exit

Enter your choice: 3
Your current balance is: $500.00
```

## Future Improvements
- Add error handling for invalid user inputs.
- Implement a login system for multiple users.
- Add functionality for transferring money between accounts.

## Author
**Precious Aitanun**  
- GitHub: [Nadira3](https://github.com/Nadira3)  
- LinkedIn: [Precious Aitanun](https://linkedin.com/in/precious-aitanun)

## License
This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
```
