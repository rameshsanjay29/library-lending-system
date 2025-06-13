# library-lending-system
Library Book Lending System
A Spring Boot-based microservice for managing a digital library system.

Features
JWT-based authentication with roles (ADMIN, MEMBER)
Book management (CRUD operations)
Book borrowing and returning system
Secure API endpoints
Swagger documentation
Prerequisites
Java 17+
Maven
PostgreSQL
Spring Boot 3+
Setup Instructions
Clone the repository:
git clone <repository-url>
cd library-lending-system
Configure PostgreSQL:

Create a database named library_db
Update application.properties with your PostgreSQL credentials
Build and Run:

mvn clean install
mvn spring-boot:run
API Documentation
Access Swagger UI at: http://localhost:8080/swagger-ui.html

API Endpoints
Authentication
POST /api/auth/login - Login with credentials
POST /api/auth/register - Register new user
Books (Requires JWT Token)
GET /api/books - View all books
POST /api/books - Add new book (ADMIN only)
PUT /api/books/{id} - Update book (ADMIN only)
DELETE /api/books/{id} - Delete book (ADMIN only)
POST /api/books/borrow/{id} - Borrow book (MEMBER only)
POST /api/books/return/{id} - Return book (MEMBER only)
Using JWT Authentication
Register a user:
curl -X POST http://localhost:8080/api/auth/register \
-H "Content-Type: application/json" \
-d '{"username": "user", "password": "password", "roles": ["MEMBER"]}'
Login to get JWT token:
curl -X POST http://localhost:8080/api/auth/login \
-H "Content-Type: application/json" \
-d '{"username": "user", "password": "password"}'
Use the token in subsequent requests:
curl -X GET http://localhost:8080/api/books \
-H "Authorization: Bearer <your-token>"
Security Notes
Passwords are encrypted using BCrypt
JWT tokens have an expiration time
All API endpoints are protected with Spring Security
Role-based access control is implemented
