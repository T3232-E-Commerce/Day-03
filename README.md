# Student Management API

A Spring Boot REST API for managing student information. This API provides endpoints to create, read, update and delete student records.

## Table of Contents
- [Overview](#overview)
- [Features](#features)
- [API Endpoints](#api-endpoints)
- [Model](#model)
- [Setup and Installation](#setup-and-installation)
- [Testing with Postman](#testing-with-postman)
- [Postman Collection](#postman-collection)
- [Common Issues](#common-issues)

## Overview

This Student Management API is built with Spring Boot and allows users to manage student records. It includes capabilities for storing student registration numbers, names, ages, courses, and GPAs.

## Features

- Create, read, update, and delete student records
- Retrieve all students
- Find students by registration number
- Filter students by age range
- Sort students by GPA

## API Endpoints

| Method | URL                       | Description                              |
|--------|---------------------------|------------------------------------------|
| GET    | /app/msg                  | Returns a greeting message               |
| GET    | /app/name                 | Returns application name                 |
| GET    | /app/age/{age}            | Returns message with provided age        |
| GET    | /app/student              | Returns a sample student                 |
| GET    | /app/students             | Returns all students                     |
| GET    | /app/student/{id}         | Finds a student by registration number   |
| GET    | /app/students/age-between | Returns students aged between 20 and 23  |
| GET    | /app/students/sort-by-gpa | Returns all students sorted by GPA (desc)|
| POST   | /app/students             | Adds a new student                       |
| PUT    | /app/students/{id}        | Updates an existing student              |
| DELETE | /app/students/{id}        | Deletes a student                        |

## Model

### Student

```java
public class Student {
    private String regNo;
    private String name;
    private int age;
    private String course;
    private double gpa;
    
    // Constructors, getters, and setters
}
```

## Setup and Installation

1. Ensure you have Java and Maven installed
2. Clone the repository
3. Navigate to the project directory
4. Run `mvn spring-boot:run` to start the application
5. The API will be available at `http://localhost:8080`

## Testing with Postman

You can test all endpoints using Postman:

1. **GET Requests**: 
   - Simply enter the URL (e.g., `http://localhost:8080/app/students`)
   - Send the request

2. **POST Request** (Add a new student):
   - Set method to POST
   - URL: `http://localhost:8080/app/students`
   - Headers: `Content-Type: application/json`
   - Body (raw, JSON):
     ```json
     {
         "regNo": "2020/ICT/05",
         "name": "Alice",
         "age": 22,
         "course": "ICT",
         "gpa": 3.75
     }
     ```

3. **PUT Request** (Update a student):
   - Set method to PUT
   - URL: `http://localhost:8080/app/students/2020/ICT/05` (remember to URL encode slashes)
   - Headers: `Content-Type: application/json`
   - Body (raw, JSON):
     ```json
     {
         "name": "Alice Smith",
         "age": 22,
         "course": "ICT",
         "gpa": 3.8
     }
     ```

4. **DELETE Request**:
   - Set method to DELETE
   - URL: `http://localhost:8080/app/students/2020/ICT/05` (remember to URL encode slashes)

## Postman Collection

To make testing easier, you can import a pre-configured Postman collection with all the API endpoints:

[![Run in Postman](https://run.pstmn.io/button.svg)](https://www.postman.com/student-api-collection)

### Collection Link
[Download Student API Postman Collection](https://www.postman.com/grey-water-994267/workspace/ecommerce-class-work/collection/34113257-88cd43fa-37b1-41e0-b65e-a5974bbfd62e?action=share&creator=34113257)

### Import Instructions
1. Download the Postman collection JSON file
2. Open Postman
3. Click "Import" button at the top
4. Select the downloaded JSON file
5. All API endpoints will be available in the collection
6. Update the base URL in the collection variables if needed (default: http://localhost:8080)

## Common Issues

1. **405 Method Not Allowed**:
   - Ensure you're using the correct HTTP method (GET, POST, PUT, DELETE)
   - Check that the URL is correctly formatted
   - For registration numbers with slashes (e.g., "2020/ICT/07"), make sure to URL encode them in the request URL (e.g., "2020%2FICT%2F07")

2. **404 Not Found**:
   - Verify the endpoint path is correct
   - Check that the application is running

3. **400 Bad Request**:
   - Ensure your JSON request body is correctly formatted
   - Verify all required fields are included
