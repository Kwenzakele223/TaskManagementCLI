# Technical Requirements

## 1. Programming Language

* The application must be developed using **Java**.
* Java will be used to create the application logic and CLI.

## 2. Build Tool

* The project must use **Maven**.
* Maven must manage the project's dependencies and build the application.

## 3. Database

* The application must use **SQLite** to store data.
* User and task information must be stored in the database.
* The database must contain a `users` table and a `tasks` table.

## 4. Database Connection

* The application must use **JDBC** to communicate with SQLite.
* The application must create a database connection before performing database operations.
* Database connections and other resources must be closed properly after use.

## 5. Database Operations

The application must be able to:

* Add users.
* Find users.
* Add tasks.
* Retrieve tasks.
* Update task status.
* Delete tasks.

The application must use `PreparedStatement` for database operations that use user input.

## 6. Command-Line Interface

* The application must run through the terminal/command line.
* Users must interact with the application by entering menu options and information.
* The application must display clear menus and messages.

## 7. Project Classes

The application must separate responsibilities between classes:

* `User` — stores user information.
* `Task` — stores task information.
* `DatabaseSchema` — handles the database connection and database tables.
* `UserRepository` — handles user database operations.
* `TaskRepository` — handles task database operations.
* `Main` — handles the application flow and user interaction.

## 8. Database Relationship

* Each task must be connected to a user.
* The `tasks` table must contain a `user_id`.
* `user_id` must reference the user's ID in the `users` table.
* This relationship ensures that tasks belong to the correct user.

## 9. Testing

* The project must use **JUnit** for automated testing where required.
* Tests must check that the application's important functions work correctly.
* Both successful operations and invalid situations should be tested.

## 10. Error Handling

* The application must handle database errors using appropriate exception handling.
* Invalid user input must be handled without crashing the application.
* The application must handle situations where a requested user or task does not exist.
