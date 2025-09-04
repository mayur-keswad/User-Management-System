User Management System
1. Project Overview

The User Management System (UMS) is a Java-based web application built using Spring Boot.
It allows managing users efficiently, including creating, reading, updating, and deleting user data.
The project demonstrates core Java concepts, object-oriented programming, RESTful APIs, and database integration with MySQL.

2. Features

User CRUD Operations

Create, Read, Update, Delete users.

REST API Endpoints

Exposes endpoints for external access using Spring MVC.

Database Integration

Stores user data in MySQL.

Validation & Exception Handling

Proper input validation and custom exception handling.

Project Modularization

Organized with Controller, Service, and Repository layers.

3. Technology Stack

Programming Language: Java 8+

Frameworks: Spring Boot, Spring MVC

Database: MySQL

Build Tool: Maven

Version Control: Git, GitHub

IDE: Spring Tool Suite (STS)

4. Installation & Setup

Clone the repository

git clone https://github.com/mayur-keswad/User-Management-System.git


Open the project in Spring Tool Suite (STS).

Configure MySQL Database

Create a database (e.g., user_management).

Update src/main/resources/application.properties with your MySQL username, password, and database name.

spring.datasource.url=jdbc:mysql://localhost:3306/user_management
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update


Build and Run

Use Maven to build:

mvn clean install


Run the application:

mvn spring-boot:run

5. API Endpoints
Method	URL	Description
1. GET	/users	Get all users
2. GET	/users/{id}	Get user by ID
3. POST	/users	Create new user
4. PUT	/users/{id}	Update existing user
5. DELETE	/users/{id}	Delete user

Example Request/Response can be tested using Postman.

6. Usage

Open your browser or Postman.

Use the API endpoints to perform CRUD operations.

Data will be stored in the MySQL database configured in application.properties.

7. Contributing

Fork the repository.

Create a feature branch: git checkout -b feature-name.

Commit your changes: git commit -m "Add feature".

Push to branch: git push origin feature-name.

Open a Pull Request.

8. License

This project is open-source and available under the MIT License.
