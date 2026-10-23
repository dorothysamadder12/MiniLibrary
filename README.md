# MiniLibrary 📚

**MiniLibrary** is a book discovery and reading tracker application built with Java, Spring Boot, and PostgreSQL. It helps users discover books using the Google Books API and provides a foundation for managing a personal reading experience.

## ✨ Features

- **Book Search:** Search for books using the Google Books API.
- **REST API Backend:** Built with Java and Spring Boot.
- **PostgreSQL Integration:** Stores application data in a relational database.
- **Web Interface:** A simple frontend built with HTML, CSS, and JavaScript.
- **External API Integration:** Fetches book information from Google Books.
- **Environment-Based Configuration:** Keeps database credentials and API keys outside the source code.

## 🛠️ Tech Stack

| Component | Technology |
|---|---|
| Language | Java |
| Backend | Spring Boot |
| Database | PostgreSQL |
| Frontend | HTML, CSS, JavaScript |
| External API | Google Books API |
| Build Tool | Maven |
| Development Tools | VS Code, Git, GitHub |

## 📁 Project Structure

```text
MiniLibrary/
├── src/
│   └── main/
│       ├── java/
│       │   └── ... Java application source
│       └── resources/
│           ├── static/
│           │   └── index.html
│           └── application.properties
├── pom.xml
├── mvnw
├── mvnw.cmd
├── .gitignore
└── README.md
```

## ⚙️ Prerequisites

Before running the application, install:

- Java JDK compatible with the project's Maven and Spring Boot configuration
- PostgreSQL
- Git (optional, for cloning)
- A Google Books API key

## 🚀 Getting Started

### 1. Clone the repository

```bash
git clone https://github.com/dorothysamadder12/MiniLibrary.git
cd MiniLibrary
```

### 2. Create the database

Create a PostgreSQL database named:

```sql
CREATE DATABASE minilibrary_db;
```

### 3. Configure environment variables

Set the following environment variables in your terminal. Replace the example values with your own credentials.

**Windows PowerShell:**

```powershell
$env:DB_USERNAME="postgres"
$env:DB_PASSWORD="your_postgresql_password"
$env:GOOGLE_BOOKS_API_KEY="your_google_books_api_key"
```

Do not commit real passwords or API keys to GitHub.

### 4. Verify application configuration

In `src/main/resources/application.properties`, configure the database and API key using environment variables:

```properties
spring.application.name=MiniLibrary
spring.datasource.url=jdbc:postgresql://localhost:5432/minilibrary_db
spring.datasource.username=${DB_USERNAME:postgres}
spring.datasource.password=${DB_PASSWORD}
google.books.api-key=${GOOGLE_BOOKS_API_KEY:}
```

Retain any additional JPA or application settings already present in your project.

### 5. Run the application

On Windows:

```powershell
.\mvnw.cmd spring-boot:run
```

Alternatively, use the Maven wrapper on macOS/Linux:

```bash
./mvnw spring-boot:run
```

### 6. Open the application

Once the application starts, visit:

**http://localhost:8083/**

This assumes the application is configured to run on port `8083`. If your port configuration differs, use the port shown in your application settings or startup logs.

## 🔐 Security

- Store database credentials in environment variables.
- Keep API keys out of source control.
- Never commit `.env` files containing secrets.
- Use `.gitignore` to exclude local configuration and generated files.
- Rotate any credentials that have been exposed.

## 🎯 Learning Outcomes

This project demonstrates practical experience with:

- Java backend development
- Spring Boot application configuration
- Relational database connectivity using PostgreSQL
- Third-party REST API integration
- Maven-based project management
- Git and GitHub version control
- Managing application secrets through environment variables

## 🔮 Future Enhancements

- User registration and authentication
- Personal reading lists and reading progress
- Bookmarks and favourites
- Book reviews and ratings
- Advanced search and filtering
- Unit and integration testing
- Deployment to a hosting platform

## 👩‍💻 Author

**Dorothy Samadder**

[GitHub Profile](https://github.com/dorothysamadder12)

---

*Built as a hands-on project to strengthen backend development, database management, and API integration skills.*
