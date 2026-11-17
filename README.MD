# Student Management System

A console-based Student Management System developed using Java, MySQL, and JDBC to manage student records efficiently.

## Technologies Used

- Java
- MySQL
- JDBC
- VS Code

## Features

- Add new student records
- View all students
- Search students by ID
- Update student information
- Delete student records
- MySQL database connectivity

## Project Structure

```text
StudentManagementSystem/
│
├── lib/
│   └── mysql-connector-j.jar
│
├── src/
│   ├── DBConnection.java
│   ├── Student.java
│   ├── StudentDAO.java
│   └── Main.java
│
├── .vscode/
│   └── settings.json
│
└── README.md
```

## Database Setup

Create a MySQL database:

```sql
CREATE DATABASE student_management;

USE student_management;

CREATE TABLE Students (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE,
    course VARCHAR(50),
    marks DOUBLE
);
```

## How to Run

1. Install Java JDK.
2. Install MySQL Server and MySQL Workbench.
3. Download MySQL Connector/J.
4. Add the JDBC JAR file to the `lib` folder.
5. Configure your MySQL username and password in `DBConnection.java`.
6. Run `Main.java`.

## Concepts Learned

- Object-Oriented Programming
- Encapsulation
- JDBC Connectivity
- MySQL Database Management
- CRUD Operations
- PreparedStatement
- Exception Handling

## Author

Shivani Borban

B.Tech Computer Science Engineering