# Student Management System

A multi-module JavaFX + Spring Data JPA application for managing student records.  
Built with **Spring Boot 4.1.1**, **JavaFX 21**, and **SQL Server**.

---

## Environment Requirements

| Tool | Version |
|------|---------|
| JDK  | 21 |
| Maven | 3.9+ |
| SQL Server | 2019+ (or Azure SQL) |
| JavaFX SDK | 21 (bundled via `javafx-maven-plugin`) |

---

## Database Setup

Run the following SQL on your SQL Server instance:

```sql
CREATE DATABASE StudentDB;
GO
USE StudentDB;
GO
CREATE TABLE student (
    id    BIGINT IDENTITY(1,1) PRIMARY KEY,
    name  NVARCHAR(100) NOT NULL,
    email VARCHAR(150)  NOT NULL UNIQUE,
    age   INT           NOT NULL
);
```

---

## Configuration

Edit `ui-module/src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:sqlserver://localhost:1433;databaseName=StudentDB;encrypt=false
spring.datasource.username=sa
spring.datasource.password=YOUR_PASSWORD
spring.jpa.hibernate.ddl-auto=update
```

---

## Build & Test

```bash
# Build all modules
mvn clean install -DskipTests

# Run data-module unit tests (26 tests: 10 repository + 16 service)
mvn -pl data-module test
```

---

## Run the Application

```bash
mvn -pl ui-module javafx:run
```

Or run the `Launcher` class directly from your IDE:

```
com.example.ui.Launcher
```

---

## Project Architecture

```
student-management/
├── pom.xml                          ← parent POM (Spring Boot 4.1.1)
├── data-module/                     ← Spring Data JPA module
│   └── src/
│       ├── main/java/com/example/data/
│       │   ├── pojo/Student.java
│       │   ├── repository/StudentRepository.java
│       │   ├── service/StudentService.java
│       │   ├── service/StudentServiceImpl.java
│       │   └── exception/
│       └── test/java/com/example/data/
│           ├── repository/StudentRepositoryTest.java
│           └── service/StudentServiceImplTest.java
└── ui-module/                       ← JavaFX + Spring Boot module
    └── src/main/
        ├── java/com/example/
        │   ├── StudentManagementApplication.java
        │   └── ui/
        │       ├── Launcher.java
        │       ├── JavaFxApplication.java
        │       └── controller/StudentController.java
        └── resources/
            ├── application.properties
            ├── student-view.fxml
            └── style.css
```

---

## Screenshots

| Feature | Screenshot |
|---------|-----------|
| Student list | ![List](docs/screenshots/01-list.png) |
| Add student | ![Add](docs/screenshots/02-add.png) |
| Edit student | ![Edit](docs/screenshots/03-edit.png) |
| Delete confirm | ![Delete](docs/screenshots/04-delete.png) |

---

## Author

**Nguyen Phuoc Hoai Nhat** — DE180216  
Course: HSF302 — FA26
