# Java_software-lab2

## Description
This project provides a text processing utility that replaces words of a specified length in a given text with a custom replacement string. It is implemented in Java using `StringBuilder` for efficient string manipulation and includes input validation and exception handling. 

## Calculation of the task variant
Number in the group list: **15**;

C3 = 15 % 3 = **0**;

C17 = 15 % 17 = **15**;

## Features
- Replace words of a given length with a defined replacement string.  
- Preserve punctuation, spaces, and formatting.  
- Support for words with apostrophes (`'`, `’`).  
- Input validation with clear error messages.  
- Efficient processing using `StringBuilder`. 

## How to run
First, clone the repository and navigate into the project directory:
```
git clone https://github.com/dk872/javasoftware-lab2
```
```
cd javasoftware-lab2
```

Compile the code:
```
javac src/main/java/org/example/TextProcessor.java
```

Run the program:
```
java -cp src/main/java org.example.TextProcessor
```

## Unit tests
This project includes **20** unit tests using *JUnit 5* to ensure the correctness of all core functionalities, covering basic replacements, punctuation handling, spacing variations, apostrophes, long texts, and exception cases.

### How to run tests
Make sure you have JUnit 5 configured, then run the tests with your preferred method:
  - From command line
  ```
  mvn test
  ```
  - In an IDE like IntelliJ IDEA or Eclipse using the test runner.

## Author info
Dmytro Kulyk, a student of group IM-32.
