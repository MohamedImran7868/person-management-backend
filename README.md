# Person Management Backend

A Spring Boot REST API for managing person records using MongoDB as the database.

## Overview

This project provides a RESTful API to perform CRUD (Create, Read, Update, Delete) operations on person records. It's built with Spring Boot 4.0.1 and uses MongoDB for data persistence.

## Technologies Used

- **Framework**: Spring Boot 4.0.1
- **Language**: Java
- **Database**: MongoDB
- **Build Tool**: Maven
- **Validation**: Jakarta Validation
- **Lombok**: For logging

## Project Structure

```
src/main/java/com/example/
├── MyApplication.java           # Main application entry point
├── CorsConfig.java              # CORS configuration
├── controller/
│   └── PersonController.java    # REST API endpoints
├── model/
│   └── Person.java              # Person data model
├── repositories/
│   └── PersonRepository.java    # MongoDB repository interface
└── service/
    └── PersonService.java       # Business logic layer
```

## API Endpoints

### Create a Person

**POST** `/person`

- **Request Body**:
  ```json
  {
    "name": "John Doe",
    "age": 30
  }
  ```
- **Response**: Returns the created person with generated ID

### Get All Persons

**GET** `/persons`

- **Response**: Returns a list of all persons

### Search Persons by Name

**GET** `/persons/search?name=John`

- **Query Parameters**:
  - `name`: Name to search for (default: empty string)
- **Response**: Returns a list of persons matching the search name

### Update a Person

**PUT** `/person/update/{id}`

- **Path Parameter**: `id` - Person ID to update
- **Request Body**:
  ```json
  {
    "name": "Jane Doe",
    "age": 28
  }
  ```
- **Response**: Returns the updated person

### Delete a Person

**DELETE** `/person/{id}`

- **Path Parameter**: `id` - Person ID to delete
- **Response**: HTTP 200 on successful deletion

## Data Model

### Person

- `id` (String): Unique identifier (auto-generated)
- `name` (String): Person's name (required)
- `age` (Integer): Person's age (required)

## Prerequisites

- Java 17 or higher
- Maven 3.6 or higher
- MongoDB running and accessible

## Installation & Setup

1. **Clone the repository**

   ```bash
   git clone <repository-url>
   cd demo
   ```

2. **Configure MongoDB Connection**
   - Ensure MongoDB is running on your local machine or update the connection settings in `application.properties`

3. **Build the project**

   ```bash
   mvn clean install
   ```

4. **Run the application**

   ```bash
   mvn spring-boot:run
   ```

   The application will start on `http://localhost:8080`

## Testing the API

You can test the API endpoints using curl, Postman, or any HTTP client:

### Example: Create a Person

```bash
curl -X POST http://localhost:8080/person \
  -H "Content-Type: application/json" \
  -d '{"name":"John Doe","age":30}'
```

### Example: Get All Persons

```bash
curl http://localhost:8080/persons
```

### Example: Search by Name

```bash
curl http://localhost:8080/persons/search?name=John
```

### Example: Update a Person

```bash
curl -X PUT http://localhost:8080/person/update/{id} \
  -H "Content-Type: application/json" \
  -d '{"name":"Jane Doe","age":28}'
```

### Example: Delete a Person

```bash
curl -X DELETE http://localhost:8080/person/{id}
```

## CORS Configuration

The application includes CORS configuration to allow requests from different origins. Check `CorsConfig.java` for current settings.

## Dependencies

- `spring-boot-starter-web`: For building REST APIs
- `spring-boot-starter-validation`: For data validation
- `spring-boot-starter-data-mongodb`: For MongoDB integration
- `lombok`: For login

## License

This project is provided as-is for educational and development purposes.
