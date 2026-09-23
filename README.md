# Employee CRUD - Spring Boot

A simple REST API demonstrating CRUD operations using Spring Boot, Spring Data JPA and MySQL.

## Requirements
- Java 17+
- Maven 3.9+
- MySQL 8+

## Database
The application uses:
- Database: `employee_db`
- Username: `root`
- Password: `root`

Change the credentials in `src/main/resources/application.properties` if required.

## Run
```bash
mvn clean install
mvn spring-boot:run
```

## APIs

### Create
POST `http://localhost:8080/api/employees`

```json
{
  "name": "Balaji Biradar",
  "email": "balaji@example.com",
  "department": "IT",
  "salary": 1200000
}
```

### Get All
GET `http://localhost:8080/api/employees`

### Get By ID
GET `http://localhost:8080/api/employees/1`

### Update
PUT `http://localhost:8080/api/employees/1`

```json
{
  "name": "Balaji Biradar",
  "email": "balaji@example.com",
  "department": "Engineering",
  "salary": 1400000
}
```

### Delete
DELETE `http://localhost:8080/api/employees/1`

## Architecture
Controller -> Service -> Repository -> MySQL

## Notes
The project includes request validation and a global exception handler for basic API error responses.
