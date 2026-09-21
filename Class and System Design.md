
# Class and System Design

## 1. System Structure

Project 2 uses several Java classes. Each class has a specific responsibility.

```text
                    Main
                     |
          -------------------------
          |                       |
      UserRepository        TaskRepository
          |                       |
          ↓                       ↓
       users table            tasks table
                                  |
                                  ↓
                              user_id
                                  |
                                  ↓
                              users.id
```

## 2. User Class

The `User` class represents a user in the application.

It contains information such as:

* User ID
* Username
* Password

The class is mainly responsible for storing user information.

## 3. Task Class

The `Task` class represents a task.

It contains information such as:

* Task ID
* Title
* Description
* Completed status
* User ID

The `userId` connects the task to the user who created it.

## 4. DatabaseSchema Class

The `DatabaseSchema` class manages the database setup.

It is responsible for:

* Connecting to the SQLite database.
* Creating the required database tables.
* Setting up the relationship between users and tasks.

The main tables are:

```text
users
----------------
id
name
password
```

and:

```text
tasks
----------------
id
title
description
completed
user_id
```

## 5. UserRepository Class

The `UserRepository` class handles database operations related to users.

It is responsible for:

* Saving users.
* Finding users.
* Checking whether a username exists.
* Retrieving user information for login.

It communicates with SQLite using JDBC.

## 6. TaskRepository Class

The `TaskRepository` class handles database operations related to tasks.

It is responsible for:

* Creating tasks.
* Retrieving tasks.
* Completing tasks.
* Deleting tasks.
* Finding tasks belonging to a specific user.

It uses JDBC to communicate with the SQLite database.

## 7. Main Class

The `Main` class controls the application.

It is responsible for:

* Displaying menus.
* Getting input from the user.
* Registration and login flow.
* Calling the repository classes.
* Handling user input errors.
* Showing messages to the user.
* Controlling the application flow.

## 8. How the Classes Work Together

The basic flow is:

```text
User
 ↓
Main
 ↓
UserRepository / TaskRepository
 ↓
JDBC
 ↓
SQLite Database
```

For example, when a user creates a task:

```text
User enters task
       ↓
      Main
       ↓
 TaskRepository
       ↓
     JDBC
       ↓
 SQLite tasks table
       ↓
Task saved with user's user_id
```

When the user views their tasks:

```text
User logs in
     ↓
Main gets user ID
     ↓
TaskRepository
     ↓
Find tasks using user_id
     ↓
SQLite
     ↓
User's tasks returned
     ↓
Main displays tasks
```

## 9. Database Relationship

The relationship between users and tasks is:

```text
One User
   |
   | can have
   ↓
Many Tasks
```

The `users.id` is connected to `tasks.user_id`.

This allows the application to identify which user owns each task.

## 10. Overall Design

The project separates the application into different responsibilities:

```text
Model
 ├── User
 └── Task

Database
 └── DatabaseSchema

Data Access
 ├── UserRepository
 └── TaskRepository

Application
 └── Main
```

This structure makes the project easier to understand, test, and maintain.
