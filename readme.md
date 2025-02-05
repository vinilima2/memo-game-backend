# Memo Game Backend

The **Memo Game Backend** is a RESTful API built with **Java 22**, **Spring Boot**, **JWT** for user authentication, **MariaDB** for data storage, and **Flyway** for managing database migrations. This API serves the frontend **Memo Game** application, handling user management, rankings...

## Features

- **JWT Authentication**: Secure user authentication using JSON Web Tokens (JWT) to protect routes and manage sessions.
- **User Management**: Allow users to register, log in.
- **Ranking System**: Track users' game performance and display rankings based on their scores.
- **Database Migrations**: Managed with **Flyway** to easily handle schema changes and version control.

## Technologies Used

- **Java 22**: The latest version of Java used for building the backend application.
- **Spring Boot**: A framework for building RESTful APIs with Java.
- **JWT (JSON Web Tokens)**: Used for stateless authentication to secure the application routes.
- **MariaDB**: Relational database for storing user data, rankings, and game progress.
- **Flyway**: Database migration tool for managing schema versions and keeping the database in sync.


## Summary of Endpoints

| Endpoint                      | Method | Description                                           |
|-------------------------------|--------|-------------------------------------------------------|
| `/cartas/get`                  | `GET`  | Get all cards from the database.                      |
| `/cartas/get/random`           | `GET`  | Get random cards (duplicates included).               |
| `/cartas/get/id`               | `GET`  | Get a card by its ID.                                 |
| `/cartas/get/icone`            | `GET`  | Get cards by their icon.                              |

| Endpoint                     | Method | Description                                          |
|------------------------------|--------|------------------------------------------------------|
| `/ranking/get`                | `GET`  | Get the top 10 rankings for the logged-in user.      |
| `/ranking/{nome}`             | `GET`  | Get the ranking of a specific user by their username.|

| Endpoint                     | Method | Description                                               |
|------------------------------|--------|-----------------------------------------------------------|
| `/usuarios/login`             | `POST` | Logs in a user and returns a JWT token in a cookie.       |
| `/usuarios/profile`           | `GET`  | Retrieves the profile of the logged-in user.              |
| `/usuarios/cadastrar`         | `POST` | Registers a new user with the provided details.           |
| `/usuarios/novorecorde`      | `POST` | Updates the score (pontuação) for the logged-in user.     |