# 🎓 Student Management System with JWT Authentication

A secure backend REST API application developed using **Spring Boot** with **JWT Authentication**, **Spring Security**, **Hibernate**, and **MySQL**.

---

# 🚀 Features

- Student CRUD Operations
- Secure Login using JWT Authentication
- Spring Security Integration
- Global Exception Handling
- Bean Validation
- Swagger API Documentation
- MySQL Database Integration
- Layered Architecture (Controller → Service → Repository)
- RESTful APIs
- Maven Project

---

# 🛠 Tech Stack

- Core Java
- Spring Boot
- Spring MVC
- Spring Security
- Spring Data JPA
- Hibernate
- JWT
- MySQL
- Maven
- Git
- Postman
- Swagger / OpenAPI

---

# 📂 Project Structure

```
src
 ├── controller
 ├── service
 ├── repository
 ├── entity
 ├── dto
 ├── config
 ├── security
 ├── exception
 └── util
```

---

# 🔐 Authentication Flow

```
Client
   ↓
Login API
   ↓
Spring Security
   ↓
Authentication Manager
   ↓
JWT Token Generated
   ↓
Client Receives Token
   ↓
Authorization Header
   ↓
Protected APIs
```

---

# 📌 REST APIs

## Authentication

| Method | Endpoint |
|--------|----------|
| POST | /auth/login |
| POST | /auth/refresh |

---

## Student APIs

| Method | Endpoint |
|--------|----------|
| GET | /students |
| GET | /students/{id} |
| POST | /students |
| PUT | /students/{id} |
| DELETE | /students/{id} |

---

# ⚠ Exception Handling

Implemented using

- Global Exception Handler
- @RestControllerAdvice
- ResourceNotFoundException
- MethodArgumentNotValidException

---

# ✅ Validation

Implemented using

- @Valid
- @NotBlank
- @Email
- @Min
- @Max

---

# 🗄 Database

Database

- MySQL

ORM

- Hibernate
- Spring Data JPA

---

# 🧪 API Testing

API Testing performed using

- Postman
- Swagger UI

---

# ▶ How to Run

1. Clone Repository

```
git clone https://github.com/ramkrishna38/student-management-system-jwt.git
```

2. Open in IntelliJ IDEA

3. Configure MySQL Database

4. Run Spring Boot Application

5. Open Swagger

```
http://localhost:8080/swagger-ui/index.html
```

---

# 📚 Learning

This project helped me learn

- Spring Boot
- Spring Security
- JWT Authentication
- Hibernate
- REST API Development
- Layered Architecture
- Global Exception Handling
- Validation
- Git & GitHub

---

# 👨‍💻 Author

**Ram Krishna**

Java Backend Developer

GitHub

https://github.com/ramkrishna38
